package algonquin.cst2335.vene0018.data.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> editString = new MutableLiveData<>();
    public MutableLiveData<Boolean> isSelected = new MutableLiveData<>();

    public MutableLiveData<Boolean> isCheckedLiveData = new MutableLiveData<>();



}