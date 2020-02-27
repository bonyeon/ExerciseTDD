package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStregth(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr,result);
    }
    //1. 모든 규칙을 충족하는 경우
    @Test
    void meetsAllCriteria_Then_String(){
        assertStregth("ab12!@AB", PasswordStrength.STRONG);
        assertStregth("abc1!ADD", PasswordStrength.STRONG);
    }
    //2. 길이만 8글자 미만이고 나머지는 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStregth("ab12!@A", PasswordStrength.NORMAL);
        assertStregth("Ab12!c", PasswordStrength.NORMAL);
    }
    //3. 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        assertStregth("ab!@ABqwer", PasswordStrength.NORMAL);
    }
    //4. 값이 없는 경우
    @Test
    void nullInput_Then_Invalid(){
        assertStregth(null, PasswordStrength.INVALID);
        assertStregth("", PasswordStrength.INVALID);
    }
    //5. 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStregth("ab12!@df", PasswordStrength.NORMAL);
    }
    //6. 길이가 8글자 이상인 조건만 충족하는 경우
    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStregth("asdfasfasdf", PasswordStrength.WEAK );
    }
    //7. 숫자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStregth("12345", PasswordStrength.WEAK);
    }

    //8. 대문자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStregth("ASDFG", PasswordStrength.WEAK);
    }
    //9. 아무조건도 충족하지 않는 경우
    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStregth("abc", PasswordStrength.WEAK);
    }


}
