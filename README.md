# techmahindra_muxdemux

Scalable Version of MuxDemux is implemented using Reactive Java APIs version 1.0.14
https://github.com/ReactiveX/RxJava

Design
                               ----> GetAgeByNameService 

                              | 

FacadeService ----------------|

                              | ----> GetPlaceByNameService
              
              
FacadeService implements service logic to aggregate the data from two services using Observable class APIs like subscribe for invoking the dependent services "GetAgeByNameService" and "GetPlaceByName" services asynchronously & thus avoiding hogging of the threads in the FacadeService.

Sample requests using curl

C:\Users\lankamadan>curl -X GET "localhost:8081/poc/mux/location?name=Madan"
{"result":{"headers":{},"body":{"name":"Madan","age":"35","place":"Bangalore"},"statusCode":"OK","statusCodeValue":200},"setOrExpired":true}


Optimizations
1. Usage of Reactive Java APIs for improved thread utilization in FacadeService
2. Usage of  DeferredResult in FacadeService for allowing DispatcherServlet to free the caller client thread & thus handle even more client connection requests compared to the case when DeferredResult is not used.
