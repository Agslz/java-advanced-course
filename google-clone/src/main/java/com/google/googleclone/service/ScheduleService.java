package com.google.googleclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleService {

    @Autowired
    private SpiderService spiderService;

    /**
     * Expresión cron para programar la ejecución de un método a la medianoche todos los días.
     * <p>
     * La expresión cron se descompone de la siguiente manera:
     * - Minutos: 0 - Se ejecuta cuando los minutos son 0.
     * - Horas: 0 - Se ejecuta cuando la hora es 0, es decir, a la medianoche.
     * - Días del mes: 0 - Se ejecuta cualquier día del mes.
     * - Meses: * - Se ejecuta cualquier mes.
     * - Días de la semana: * - Se ejecuta cualquier día de la semana.
     * - Año (opcional): No está especificado.
     * <p>
     * Por lo tanto, esta expresión cron se traduce a: "Ejecuta el método programado a la medianoche todos los días".
     *
     * @see <a href="https://es.wikipedia.org/wiki/Cron_(Unix)">Expresiones cron</a>
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleIndexWebPages() {
        spiderService.indexWebPages();
    }
}
