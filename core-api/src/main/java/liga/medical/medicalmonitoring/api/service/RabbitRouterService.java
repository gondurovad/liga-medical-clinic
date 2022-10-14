package liga.medical.medicalmonitoring.api.service;

public interface RabbitRouterService {

    void routeMessageWithExchange(String message);
}
