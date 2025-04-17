# hexagonal-demo

헥사고날 아키텍처 샘플

## 참고
- https://reflectoring.io/spring-hexagonal/

## 헥사고날 아키텍처란?

![image](https://github.com/user-attachments/assets/afc93051-f6d6-40e4-8bb8-748a06f11fb4)

- 비즈니스 규칙이 중앙(Core)에 위치하며, 어떠한 외부 요소에도 의존하지 않는다.
- 도메인과 외부 세계(웹, DB, 메시징 등)는 `Port` 와 `Adapter`를 통해 소통한다.
    - Port: 도메인이 외부와 소통하기 위해 정의한 인터페이스
    - Adapter: Port 구현체로 실제 외부 기술을 연결하는 부분
- 모든 의존성의 방향은 도메인을 향한다(inward dependencies).

## 구조 핵심 
```
          [ Web / UI ]                                       [ External API / DB ]
               ↓                                                    ↑
        [ Input Adapter ]                                  [ Output Adapter]
    (eg. Controller, Kafka Consumer)                  (eg. JpaAdapter, APIClient)
                 ↓                                              ↑
          [ Input Port (Interface) ]                [ Output Port (Interface) ]
               (eg., UseCase)                        (eg. LoadPort, SavePort)
                        ↓                                   ↑
                                  [   Domain   ]
                                  (eg. Services)
```
