package example;

import example.grpc.SampleRequest;
import example.grpc.SampleResponse;
import example.grpc.SendServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class StreamServer extends SendServiceGrpc.SendServiceImplBase {
    @Override
    public StreamObserver<SampleRequest> sendByStream(StreamObserver<SampleResponse> responseObserver) {
        var requests = new ArrayList<Integer>();
        return new StreamObserver<SampleRequest>() {
            @Override
            public void onNext(SampleRequest value) {
                //System.out.println("Received message: " + value.getId());

                if (value.getId() % 10000 == 0) {
                    System.out.println("Received message: " + value.getId());
                }

                requests.add(value.getId());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Received " + requests.size() + " requests");
                var response = SampleResponse.newBuilder().setMessage(requests.size()).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
