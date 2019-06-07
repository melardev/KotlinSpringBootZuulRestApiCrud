package com.melardev.cloud.zuulfilters


import com.melardev.cloud.zuulfilters.filters.ErrorFilter
import com.melardev.cloud.zuulfilters.filters.PostFilter
import com.melardev.cloud.zuulfilters.filters.PreFilter
import com.melardev.cloud.zuulfilters.filters.RouteFilter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableZuulProxy
class ZuulFiltersApplication {

    @Bean
    fun preFilter(): PreFilter {
        return PreFilter()
    }

    @Bean
    fun postFilter(): PostFilter {
        return PostFilter()
    }

    @Bean
    fun routeFilter(): RouteFilter {
        return RouteFilter()
    }

    @Bean
    fun errorFilter(): ErrorFilter {
        return ErrorFilter()
    }
}

fun main(args: Array<String>) {
    runApplication<ZuulFiltersApplication>(*args)
}
