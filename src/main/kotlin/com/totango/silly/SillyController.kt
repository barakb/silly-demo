package com.totango.silly

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class SillyController {
    @GetMapping(path=["/echo/{msg}"],  produces = [MediaType.TEXT_PLAIN_VALUE])
    fun echo(@PathVariable("msg") msg: String): Mono<String> = Mono.just(msg)
}