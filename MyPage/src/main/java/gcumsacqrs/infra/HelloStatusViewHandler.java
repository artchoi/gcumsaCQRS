package gcumsacqrs.infra;

import gcumsacqrs.config.kafka.KafkaProcessor;
import gcumsacqrs.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class HelloStatusViewHandler {

    @Autowired
    private HelloStatusRepository helloStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenHellod_then_CREATE_1(@Payload Hellod hellod) {
        try {
            if (!hellod.validate()) return;

            // view 객체 생성
            HelloStatus helloStatus = new HelloStatus();
            // view 객체에 이벤트의 Value 를 set 함
            helloStatus.setId(hellod.getId());
            helloStatus.setHelloId(hellod.getId());
            helloStatus.setWorldId(hellod.getId());
            helloStatus.setHello(hellod.getHello());
            // view 레파지 토리에 save
            helloStatusRepository.save(helloStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenWorlded_then_CREATE_2(@Payload Worlded worlded) {
        try {
            if (!worlded.validate()) return;

            // view 객체 생성
            HelloStatus helloStatus = new HelloStatus();
            // view 객체에 이벤트의 Value 를 set 함
            helloStatus.setWorld(worlded.getWorld());
            // view 레파지 토리에 save
            helloStatusRepository.save(helloStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenHellod_then_UPDATE_1(@Payload Hellod hellod) {
        try {
            if (!hellod.validate()) return;
            // view 객체 조회

            List<HelloStatus> helloStatusList = helloStatusRepository.findByHello(
                hellod.getHello()
            );
            for (HelloStatus helloStatus : helloStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                helloStatus.setId(hellod.getId());
                helloStatus.setHelloId(hellod.getId());
                helloStatus.setWorldId(hellod.getId());
                helloStatus.setWorldId(hellod.getId());
                helloStatus.setHello(hellod.getHello());
                // view 레파지 토리에 save
                helloStatusRepository.save(helloStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenWorlded_then_UPDATE_2(@Payload Worlded worlded) {
        try {
            if (!worlded.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
