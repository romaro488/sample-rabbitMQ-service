## Capstone project: messaging with RabbitMQ

## How to run the project ?

In the terminal write next command:
"docker-compose up rabbit1 rabbit2 rabbit3" - It will run 3 nodes

## How to run application Services ?

* Sender:
  Simple Spring Boot application sending 10 messages per second to the exchange "ex.example"
  with the routing key "rk.example"
    * hostname: sender

* Receiver:
  Simple Spring Boot application receiving and messages from the queue "q.example"
    * hostname: receiver

- You can run services manually. Open main class of the service and press run button. Make sure that rabbitMQ nodes are
  running. Open **RabbitMQ UI:** `http://localhost:15672` `http://localhost:15673/` or `http://localhost:15674/`
  Write userName "guest" and password "guest"

## How to stop one of the nodes ?

- Shutdown the first RabbitMQ node and make sure the flow keeps working
- Restart the first RabbitMQ node and make sure it joined the cluster

- write next command in the new terminal window
  `docker-compose down <containerName>`  
  For example `docker-compose down rabbit1`

## How to stop all containers??

Write next command in the terminal `docker-compose down`
  
