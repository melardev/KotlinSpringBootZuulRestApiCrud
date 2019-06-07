package com.melardev.cloud.zuulfilters.filters

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants

import javax.servlet.http.HttpServletResponse

class PostFilter : ZuulFilter() {
    override fun filterType(): String {
        return FilterConstants.POST_TYPE
    }

    override fun filterOrder(): Int {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    @Throws(ZuulException::class)
    override fun run(): Any? {
        val context = RequestContext.getCurrentContext()
        val servletResponse = context.response
        servletResponse.addHeader("X-Custom-Header", "Something")
        return null
    }
}
