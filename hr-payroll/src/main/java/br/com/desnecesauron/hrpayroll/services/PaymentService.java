package br.com.desnecesauron.hrpayroll.services;

import br.com.desnecesauron.hrpayroll.entities.Payment;
import br.com.desnecesauron.hrpayroll.entities.Worker;
import br.com.desnecesauron.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();

        if (worker == null) {
            throw new IllegalArgumentException("Worker not found with id: " + workerId);
        }

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
