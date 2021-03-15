package demo.presentation.orderservice.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.presentation.orderservice.messaging.Message;
import demo.presentation.orderservice.messaging.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private Producer producer;

    @PostMapping()
    public ResponseEntity<String> createCustomerOrder(@RequestBody Message message) throws JsonProcessingException {
        producer.sendMessage(new ObjectMapper().writeValueAsString(message));
        return ResponseEntity
                .accepted()
                .build();
    }
}
