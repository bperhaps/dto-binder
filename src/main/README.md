# DTO Binder

Object and DTO binding make easier!

## Introduce

Binding DTOs to objects with many fields is expensive.

DTO Binder increases productivity by performing this process automatically.

It also helps preserve encapsulation by removing meaningless getters.

## Todo
- [x] 동일 이름을 기반으로 바인딩 시키도록 한다.
- [x] 중첩된 객체가 존재하는 경우, 기본전략은 embedded, 필요한 경우 새로운 DTO로 만들어 처리한다.

### later
- [ ] embedded로 처리할 경우, DTO와 매핑될 필드 이름을 지정할 수 있게 한다.
- [ ] Annotation 기반을 고려해 본다 (도메인에 침투하고, 계층 구조를 망가트리는 점에서 죄대한 지양한다).
