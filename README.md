# java-lotto

로또 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


## 로또 기능 요구사항
- [ ] 구입 금액을 입력받을 수 있다.
  - [ ] 구입 금액은 1000 단위로만 입력한다.
- [ ] 구입한 로또 갯수를 출력한다.
- [ ] 구입한 로또 갯수 만큼 로또 번호 6개를 발급 후 출력한다.
  - [ ] 로또 번호는 1부터 45까지이다.
  - [ ] 한 로또에 중복되는 번호는 없다.
  - [ ] 한 로또의 번호 출력은 오름차순이다.
- [ ] 당첨 번호 6개와 보너스 번호 1개를 입력받을 수 있다.
  - [ ] 당첨 번호와 보너스 번호는 반드시 숫자여야 한다.
  - [ ] 당첨 번호와 보너스 번호는 빈 문자열이거나 null 일 수 없다.
  - [x] 로또 번호는 1부터 45까지이다.
  - [ ] 당첨번호와 보너스 번호 모두 중복되는 번호는 없다.
  - [x] 당첨번호가 6개가 아니면 예외를 던진다.
  - [x] 당첨 번호들은 `,`로 구분해서 입력한다.
  - [x] 당첨 번호 앞 뒤 공백은 제거한다.
- [x] 발급된 로또의 순위를 파악한다.
  - [X] 1등 : 숫자 6개 일치
  - [x] 2등 : 숫자 5개 + 보너스번호
  - [x] 3등 : 숫자 5개
  - [x] 4등 : 숫자 4개
  - [x] 5등 : 숫자 3개
  - [x] 꽝 : 숫자 2개 ~ 숫자 0개
- [ ] 전체 발급된 로또의 통계를 출력한다.
  - [x] 모든 당첨 로또의 상금 합 / 구입 금액 이 수익률이다.


## 객체 키워드
- 구입 금액
- 로또
- 로또 번호
- 당첨 번호 + 보너스 번호
- 입력 parser -> `, `로 구분
- 랭크(열거형)
- 통계 내는 역할하는 애
- 통계 데이터를 전달하는 dto
- 로또 기계 -> 전체적인 흐름제어


## 시간되면 한번 고민
- Prize.multiply에 매개변수 타입이 Integer 말고 Wrapper Class로 변경
- 로또 번호를 감쌀것인가? vs winningNumbers를 사용해서 보너스넘버도 같이 감쌀것인가?

Validator -> 여러개 생성 
Validator -> 기본적으로 포맷확인(REGEX)[String], 값 확인(범위, 양수 or 음수, 배수)[머가 될지 모름]
Validator -> 연결? Generic?  

LottoNumberParser
 AbValid validator
 Convertor<LottoNumbers> convertor

 LottoNumbers convert(String value) {
  validator.validate(value)
  return convertor.convert(value);
 }




AbstractValidator
  List<Validator> validators;

  for (validator : vaidators) {
    valdator.validate(value);
  }

LottoNumberValidator extends AbValid 
  조합 

BonusNumberValidator extends AbValid
  조합
