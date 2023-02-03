package com.example.calculous;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;


import com.example.calculous.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding ;
    private String a ="";
    private int [] number = {0,1 ,2,3,4,5,6,7,8,9};
    private  int sum ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.zero.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[0]));
            binding.edittext.setText(a);
        });
        binding.one.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[1]));
            binding.edittext.setText(a);

        });
        binding.two.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[2]));
            binding.edittext.setText(a);
        });
        binding.three.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[3]));
            binding.edittext.setText(a);
        });
        binding.four.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[4]));
            binding.edittext.setText(a);
        });
        binding.five.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[5]));
            binding.edittext.setText(a);
        });
        binding.six.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[6]));
            binding.edittext.setText(a);
        });
        binding.seven.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[7]));
            binding.edittext.setText(a);
        });
        binding.eight.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[8]));
            binding.edittext.setText(a);
        });
        binding.nine.setOnClickListener(view -> {
            a = a.concat(Integer.toString(number[9]));
            binding.edittext.setText(a);
        });
        binding.delete.setOnClickListener(view -> {
            String b = "";
             for (int i = 0 ; i < a.length() -1 ; i++)
             {
                 b = b.concat(String.valueOf(a.charAt(i)));
             }
             a = b;
             binding.edittext.setText(a);
        });
        binding.restart.setOnClickListener(view -> {
            a = "";
            binding.edittext.setText(a);
        });
        binding.minus.setOnClickListener(view -> {
            a = a.concat("-");
            binding.edittext.setText(a);
        });
        binding.plus.setOnClickListener(view -> {
            a = a.concat("+");
            binding.edittext.setText(a);
        });
        binding.multiply.setOnClickListener(view -> {
            a = a.concat("x");
            binding.edittext.setText(a);
        });
        binding.divide.setOnClickListener(view -> {
            a = a.concat("÷");
            binding.edittext.setText(a);
        });
        binding.percent.setOnClickListener(view -> {
            a = a.concat("%");
            binding.edittext.setText(a);

        });
        binding.equal.setOnClickListener(view ->
        {
            if (binding.edittext.getText().toString().equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please enter operation!!!" ,Toast.LENGTH_SHORT).show();
            }else {
                String temp = "";//lưu số ở dạng chuỗi xong chuyển sang kiểu integer
                int[] array_number = new int[1000];// lưu mảng số được chuyển từ temp
                String arithmetic_character = "";//lưu các dấu + , - , x , :
                int m = 0;
                //Tách chuỗi và số lưu ở hai kiểu array khác nhau
                for (int i = 0; i < a.length(); i++) {
                    if (String.valueOf(a.charAt(i)).equals("+") || String.valueOf(a.charAt(i)).equals("-") || String.valueOf(a.charAt(i)).equals("x") || String.valueOf(a.charAt(i)).equals("÷")) {
                        arithmetic_character = arithmetic_character.concat(String.valueOf(a.charAt(i)));
                        array_number[m++] = Integer.parseInt(temp);
                        temp = "";
                    } else {
                        temp = temp.concat(String.valueOf(a.charAt(i)));
                    }

                }
                array_number[m++] = Integer.parseInt(temp); //cần lưu ý , giải thuật chưa ổn , chưa bao quát được hết trường hợp
                sum = array_number[0];
                int j = 1;
                for (int i = 0; i < arithmetic_character.length(); i++) {
                    if (String.valueOf(arithmetic_character.charAt(i)).equals("+")) {
                        sum = sum + array_number[j++];
                    } else if (String.valueOf(arithmetic_character.charAt(i)).equals("-")) {
                        sum = sum - array_number[j++];
                    } else if (String.valueOf(arithmetic_character.charAt(i)).equals("x")) {
                        sum = sum * array_number[j++];
                    } else if (String.valueOf(arithmetic_character.charAt(i)).equals("÷")) {
                        sum = sum / array_number[j++];
                    }

                }
                a = String.valueOf(sum);
                binding.edittext.setText(a);
            }
        });

    }

}