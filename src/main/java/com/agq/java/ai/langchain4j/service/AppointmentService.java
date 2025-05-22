package com.agq.java.ai.langchain4j.service;

import com.agq.java.ai.langchain4j.entity.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}