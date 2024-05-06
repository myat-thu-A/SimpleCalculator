package it.myatthu.simplecalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import it.myatthu.simplecalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }


    public void onNumberClicked(View view) {
        Button btn = (Button) view; //Up casting & Down casting
        Log.d("Myat", btn.getText().toString());
        if(binding.etCalculator.getText().toString().equals("0"))
            binding.etCalculator.setText(btn.getText().toString());
        else
            binding.etCalculator.append(btn.getText().toString());
    }

    public void onOperatorClicked(View view) {
        int operator = view.getId();
        if(operator == R.id.btAdd) {
            this.operator = "+";

            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);

        } else if (operator == R.id.btSub) {
            this.operator = "-";

            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);

        } else if (operator == R.id.btMul) {
            this.operator = "*";

            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);

        } else if (operator == R.id.btDiv) {
            this.operator = "/";

            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);

        } else if (operator == R.id.btEqual) {
            int firstNumber = Integer.parseInt(binding.tvOperation.getText().toString());
            int secondNumber = Integer.parseInt(binding.etCalculator.getText().toString());
            calculate(firstNumber, secondNumber);
            binding.tvOperation.setText("");
            binding.tvOperator.setText("");
        }


    }


    private void calculate(int firstNumber, int secondNumber) {
        int result = 0;
        if(this.operator.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (this.operator.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (this.operator.equals("*")) {
            result = firstNumber + secondNumber;
        } else {
            result = firstNumber / secondNumber;
        }
        binding.etCalculator.setText(String.valueOf(result));

    }

    public void onClearClicked(View view) {
        binding.etCalculator.setText("");
    }
}