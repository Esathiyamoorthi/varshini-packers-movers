package com.example.demo.controller;

import com.example.demo.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/book")
    public String bookService(@RequestBody Booking booking) {

        // Console print
        System.out.println("🔥 New Booking Received 🔥");

        System.out.println("Name: " + booking.getName());
        System.out.println("Phone: " + booking.getPhone());
        System.out.println("Service: " + booking.getService());
        System.out.println("Message: " + booking.getMessage());

        // Email message
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("sm010010001@gmail.com");

        mail.setSubject(" New Booking Received");

        mail.setText(
                "Name: " + booking.getName() +
                "\nPhone: " + booking.getPhone() +
                "\nService: " + booking.getService() +
                "\nMessage: " + booking.getMessage()
        );

        // Send email
        mailSender.send(mail);

        return "Booking Saved Successfully ✅";
    }
}