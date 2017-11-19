package android.cuong.surveymvp.data;

import android.cuong.surveymvp.data.model.Option;
import android.cuong.surveymvp.data.model.Question;
import android.cuong.surveymvp.data.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by QUOC CUONG on 19/11/2017.
 */

public interface DbHelper {

    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();

    Observable<List<Question>> getAllQuestions();

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveOption(Option option);

    Observable<Boolean> saveQuestionList(List<Question> questionList);

    Observable<Boolean> saveOptionList(List<Option> optionList);
}
