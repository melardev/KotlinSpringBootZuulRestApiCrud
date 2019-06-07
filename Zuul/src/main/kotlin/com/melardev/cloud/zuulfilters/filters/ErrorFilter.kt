package com.melardev.cloud.zuulfilters.filters

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants

import javax.servlet.http.HttpServletRequest

class ErrorFilter : ZuulFilter() {
    override fun filterType(): String {
        return FilterConstants.ERROR_TYPE
    }

    override fun filterOrder(): Int {
        return FilterConstants.SEND_ERROR_FILTER_ORDER - 1 // Is this Ok? SEND_ERROR_FILTER_ORDER is 0 ...
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    @Throws(ZuulException::class)
    override fun run(): Any? {
        val ctx = RequestContext.getCurrentContext()
        val request = ctx.request

        println("Request Method : " + request.method + " Request URL : " + request.requestURL.toString())
        return null
    }
}
