package liga.medical.medicalmonitoring.core.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.dto.MessageType;
import liga.medical.common.dto.RabbitMessageDTO;
import liga.medical.medicalmonitoring.api.service.RabbitRouterService;
import liga.medical.medicalmonitoring.core.annotations.DBLog;
import liga.medical.medicalmonitoring.core.config.ExchangeConfig;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitRouterServiceImpl implements RabbitRouterService {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    public RabbitRouterServiceImpl(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @DBLog
    @Override
    public void routeMessageWithExchange(String message) {
        rabbitTemplate.setExchange(ExchangeConfig.DIRECT_EXCHANGE_NAME);

        try {
            RabbitMessageDTO messageDto = objectMapper.readValue(message, RabbitMessageDTO.class);
            rabbitTemplate.convertAndSend(messageDto.getType().toString(), message);
            System.out.println(String.format("The router forwarded the message with the type [%s].", messageDto.getType().toString()));
        } catch (JsonProcessingException e) {
            rabbitTemplate.convertAndSend(MessageType.ERROR.toString(), e.getMessage());
            System.out.println("An error occurred while redirecting the message.");
        }
    }
}
