package com.example.daw_resilience.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class EntelService {
    @CircuitBreaker(name = "planService", fallbackMethod = "handlePlanCheckFailure")
    public String checkPlanAvailability(Long planId) {

        if (planId < 1 || planId > 10) {
            throw new RuntimeException("Simulación de un fallo para activar el método de recuperación.");
        }
        return "Plan ID " + planId + " está disponible para contratación.";
    }

    public String handlePlanCheckFailure(Long planId, Throwable throwable) {
        return "No se pudo verificar la disponibilidad del plan ID: "
                + planId + ". Intente nuevamente más tarde o contáctenos.";
    }
}
