package lotto.model;




import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;


import static lotto.util.MagicNumbers.MIN_NUMBER;
import static lotto.util.MagicNumbers.MAX_NUMBER;
import static lotto.util.MagicNumbers.LOTTO_COUNT;


public class MyLottoNumber {
    private final List<Integer> myLottoNumber;

    private MyLottoNumber(){
        this.myLottoNumber = sortedRandomNumber(generateRandomNumber());
    }

    public static MyLottoNumber generateLotto(){
        return new MyLottoNumber();
    }

    private List<Integer> generateRandomNumber(){
        List<Integer> MyNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT);
        return MyNumbers;
    }

    private List<Integer> sortedRandomNumber(List<Integer> MyNumbers){
        if(!isSortedNumber(MyNumbers))
            Collections.sort(MyNumbers);
        return MyNumbers;
    }

    private boolean isSortedNumber(List<Integer> MyNumbers) {
        int past = 0;
        for(int mynumber : MyNumbers){
            if(past < mynumber){
                past = mynumber;
                continue;
            }
            return false;
        }
        return true;
    }


    //Override 필수
    @Override
    public String toString(){
        return myLottoNumber.toString();
    }

    public List<Integer> getMyLottoNumber() {
        return myLottoNumber;
    }
}
