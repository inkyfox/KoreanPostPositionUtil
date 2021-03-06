[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.inkyfox/korean-post-position-util/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.inkyfox/korean-post-position-util)

# KoreanPostPositionUtil

종성에 따른 한글 조사 (은/는, 이/가, 을/를, 과/와)를 붙여주는 코틀린 유틸리티 

Kotlin Utility for Korean Hangul post-position letters

- 원래의 문장의 모습인 `명사.조사`의 형식으로 사용하여 가독성이 높다.
- `으로/로`와 같이 종성이 없거나 `ㄹ`로 끝나는 지에 따른 조사에 대해서도 동작한다.
- 한글 뿐 아니라 숫자와 일부 영문도 지원한다.
- `명사(설명).조사`의 형식에선 괄호를 무시한다.
- 자바 코드에서도 사용할 수 있다.

## Download

Maven:

``` xml
<dependency>
    <groupId>com.github.inkyfox</groupId>
    <artifactId>korean-post-position-util</artifactId>
    <version>1.0.3</version>
</dependency>
```

Gradle:

``` groovy
compile 'com.github.inkyfox:korean-post-position-util:1.0.3'
```

## import

``` kotlin
import com.genxhippies.korean.*
```

## 지원하는 조사

`명사.조사`의 형식에서 조사는 하나만 쓸 수 있다. 즉 `name.은는`의 경우 `name.은` 혹은 `name.는`의 형식으로 동일하게 사용 가능해서 변수명에 따라 자연스러운 조사로 코딩할 수 있다.

### 은/는

``` kotlin
// 팝은 즐겁습니다.
// 가요는 즐겁습니다.
// Pop은(는) 즐겁습니다.
"${song.은는} 즐겁습니다."
"${song.은} 즐겁습니다."
"${song.는} 즐겁습니다."
```

### 이/가

``` kotlin
// 눈이 옵니다.
// 비가 옵니다.
// Rain이(가) 옵니다.
"${what.이가} 옵니다."
"${what.이} 옵니다."
"${what.가} 옵니다."
```

### 을/를

``` kotlin
// 밥을 먹습니다.
// 국수를 먹습니다.
// Burger을(를) 먹습니다.
"${food.을를} 먹습니다."
"${food.을} 먹습니다."
"${food.를} 먹습니다."
```

### 과/와

``` kotlin
// 서울과 연결합니다.
// 제주와 연결합니다.
// New York과(와) 연결합니다.
"${city.과와} 연결합니다."
"${city.과} 연결합니다."
"${city.와} 연결합니다."
```

### 으로/로

``` kotlin
// 부산으로 출발합니다.
// 서울로 출발합니다. ('ㄹ' 종성)
// 제주로 출발합니다.
// New York(으)로 출발합니다.
"${city.으로} 출발합니다."
"${city.로} 출발합니다."
```

### 이여/여
``` kotlin
// 꿈에도 그리던 서울이여.
// 꿈에도 그리던 제주여.
// 꿈에도 그리던 New York(이)여.
"꿈에도 그리던 ${city.이여}."
"꿈에도 그리던 ${city.여}."
```

### (이)는, (이)가, (이)를, (이)와

`이`를 이름에 붙여 친근함을 나타내는 경우로 `name._이` 혹은 ``name.`(이)` ``로 사용할 수 있다.

``` kotlin
// 영희
// 길동이
// Jone(이)
"${name._이}"
"${name.`(이)`}"

// 영희는
// 길동이는
// Jone(이)는
"${name._이.는}"
"${name.`(이)`.는}"

// 영희가
// 길동이가
// Jone(이)가
"${name._이.가}"
"${name.`(이)`.가}"

// 영희를
// 길동이를
// Jone(이)를
"${name._이.를}"
"${name.`(이)`.를}"

// 영희와
// 길동이와
// Jone(이)와
"${name._이.와}"
"${name.`(이)`.와}"
```

## 특수한 케이스

### 마지막 문자가 숫자인 경우

숫자의 한글 발음('일', '이', '삼', ...)에 따라 조사가 붙는다.

``` kotlin
// 1이 되었습니다.
// 2가 되었습니다.
// 3이 되었습니다.
"${num.이가} 되었습니다."
"${num.이} 되었습니다."
"${num.가} 되었습니다."

// 1로 변경되었습니다.
// 2로 변경되었습니다.
// 3으로 변경되었습니다.
"${num.으로} 변경되었습니다."
"${num.로} 변경되었습니다."
```

### null 대응

Nullable 타입에 붙일 수 있어서 Null 체크를 할 필요 없고, `null` 문자열로 치환되어 조사가 붙는다.

``` kotlin
// null이 되었습니다.
"${null.이가} 되었습니다."
```

### `String`외의 다양한 타입 대응

모든 조사는 Any? 타입에 붙일 수 있고 toString()으로 얻어진 문자열에 조사를 붙인다. 따라서 숫자 타입에도 바로 조사를 붙일 수 있다.

``` kotlin
// 1이 되었습니다.
"${1.이가} 되었습니다."
// 2가 되었습니다.
"${2.이가} 되었습니다."
// 3이 되었습니다.
"${3.이가} 되었습니다."
```

### 괄호 처리

`명사(설명).조사`의 형식에선 괄호를 무시한다.

``` kotlin
// 코틀린(Kotlin)을 사용합니다.
// 자바(Java lang)를 사용합니다.
"${lang.을} 사용합니다."
```

### 특수문자 처리

몇가지 특수문자로 끝나는 경우 그 문자를 무시한다.

### Java 대응

자바에서도 호출할 수 있다.

``` java
import com.genxhippies.korean.KoUtils;
```

``` java
KoUtils.은는(song) + " 즐겁습니다."
KoUtils.이가(what) + " 옵니다."
KoUtils.을를(food) + " 먹습니다."
KoUtils.과와(city) + " 연결합니다."
KoUtils.으로(city) + " 출발합니다."
"꿈에도 그리던 " + KoUtils.이여(city) + "."
KoUtils._이(name)
```

