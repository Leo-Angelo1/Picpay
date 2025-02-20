package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) {
        try {
            String email = user.getEmail();
            NotificationDTO notificationRequest = new NotificationDTO(email, message);

            System.out.println("Enviando notificação para: " + email);
            System.out.println("Mensagem: " + message);

            ResponseEntity<String> notificationResponse = restTemplate.postForEntity(
                    "https://util.devi.tools/api/v1/notify",
                    notificationRequest,
                    String.class
            );

            System.out.println("Status Code: " + notificationResponse.getStatusCode());
            System.out.println("Response Body: " + notificationResponse.getBody());

            if (!notificationResponse.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Serviço de notificação está fora do ar");
            }

        } catch (Exception e) {
            System.err.println("Erro ao enviar notificação: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
