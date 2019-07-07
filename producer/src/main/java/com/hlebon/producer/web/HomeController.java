package com.hlebon.producer.web;

import com.hlebon.producer.service.PracticalTipSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController("/")
public class HomeController {

    private final PracticalTipSender practicalTipSender;
    private final AtomicInteger counter = new AtomicInteger();

    public HomeController(PracticalTipSender practicalTipSender) {
        this.practicalTipSender = practicalTipSender;
    }

    @GetMapping
    public String home() {
        return "Das work " + this.hashCode();
    }

    @GetMapping("addInQueue")
    public String addInQueue() {
        practicalTipSender.sendPracticalTip();
        return "Total messages " + counter.getAndIncrement();
    }
}
