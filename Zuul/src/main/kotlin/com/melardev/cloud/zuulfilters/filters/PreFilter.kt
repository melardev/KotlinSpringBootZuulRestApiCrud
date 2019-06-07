package com.melardev.cloud.zuulfilters.filters

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants

class PreFilter : ZuulFilter() {
    override fun filterType(): String {
        return FilterConstants.PRE_TYPE
    }

    override fun filterOrder(): Int {
        // Run before PreDecoration
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    @Throws(ZuulException::class)
    override fun run(): Any? {
        val requestContext = RequestContext.getCurrentContext()
        val request = requestContext.request

        println("Request Method : " + request.method + " Request URL : " + request.requestURL.toString())
        return null
    }
}
