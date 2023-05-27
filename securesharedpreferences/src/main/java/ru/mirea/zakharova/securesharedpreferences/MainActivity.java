package ru.mirea.zakharova.securesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;

import java.io.IOException;
import java.security.GeneralSecurityException;

import ru.mirea.zakharova.securesharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences secureSharedPreferences;
        KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;
        try {
            String mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec);
            secureSharedPreferences = EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    mainKeyAlias,
                    getBaseContext(),
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
            secureSharedPreferences.edit().putString("secure", "Борис Пастернак");
            secureSharedPreferences.edit().putString("secure", "Во всем мне хочется дойти\n" +
                    "До самой сути.\n" +
                    "В работе, в поисках пути,\n" +
                    "В сердечной смуте.\n" +
                    "\n" +
                    "До сущности протекших дней,\n" +
                    "До их причины,\n" +
                    "До оснований, до корней,\n" +
                    "До сердцевины.\n" +
                    "\n" +
                    "Все время схватывая нить\n" +
                    "Судеб, событий,\n" +
                    "Жить, думать, чувствовать, любить,\n" +
                    "Свершать открытья.\n" +
                    "\n" +
                    "О, если бы я только мог\n" +
                    "Хотя отчасти,\n" +
                    "Я написал бы восемь строк\n" +
                    "О свойствах страсти.\n" +
                    "\n" +
                    "О беззаконьях, о грехах,\n" +
                    "Бегах, погонях,\n" +
                    "Нечаянностях впопыхах,\n" +
                    "Локтях, ладонях.\n" +
                    "\n" +
                    "Я вывел бы ее закон,\n" +
                    "Ее начало,\n" +
                    "И повторял ее имен\n" +
                    "Инициалы.\n" +
                    "\n" +
                    "Я б разбивал стихи, как сад.\n" +
                    "Всей дрожью жилок\n" +
                    "Цвели бы липы в них подряд,\n" +
                    "Гуськом, в затылок.\n" +
                    "\n" +
                    "В стихи б я внес дыханье роз,\n" +
                    "Дыханье мяты,\n" +
                    "Луга, осоку, сенокос,\n" +
                    "Грозы раскаты.\n" +
                    "\n" +
                    "Так некогда шопен вложил\n" +
                    "Живое чудо\n" +
                    "Фольварков, парков, рощ, могил\n" +
                    "В свои этюды.\n" +
                    "\n" +
                    "Достигнутого торжества\n" +
                    "Игра и мука\n" +
                    "Натянутая тетива\n" +
                    "Тугого лука.");
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }

        binding.textView2.setText(secureSharedPreferences.getString("secure", "Борис Пастернак"));
        binding.textView.setText(secureSharedPreferences.getString("secure", "Во всем мне хочется дойти\n" +
                "До самой сути.\n" +
                "В работе, в поисках пути,\n" +
                "В сердечной смуте.\n" +
                "\n" +
                "До сущности протекших дней,\n" +
                "До их причины,\n" +
                "До оснований, до корней,\n" +
                "До сердцевины.\n" +
                "\n" +
                "Все время схватывая нить\n" +
                "Судеб, событий,\n" +
                "Жить, думать, чувствовать, любить,\n" +
                "Свершать открытья.\n" +
                "\n" +
                "О, если бы я только мог\n" +
                "Хотя отчасти,\n" +
                "Я написал бы восемь строк\n" +
                "О свойствах страсти.\n" +
                "\n" +
                "О беззаконьях, о грехах,\n" +
                "Бегах, погонях,\n" +
                "Нечаянностях впопыхах,\n" +
                "Локтях, ладонях.\n" +
                "\n" +
                "Я вывел бы ее закон,\n" +
                "Ее начало,\n" +
                "И повторял ее имен\n" +
                "Инициалы.\n" +
                "\n" +
                "Я б разбивал стихи, как сад.\n" +
                "Всей дрожью жилок\n" +
                "Цвели бы липы в них подряд,\n" +
                "Гуськом, в затылок.\n" +
                "\n" +
                "В стихи б я внес дыханье роз,\n" +
                "Дыханье мяты,\n" +
                "Луга, осоку, сенокос,\n" +
                "Грозы раскаты.\n" +
                "\n" +
                "Так некогда шопен вложил\n" +
                "Живое чудо\n" +
                "Фольварков, парков, рощ, могил\n" +
                "В свои этюды.\n" +
                "\n" +
                "Достигнутого торжества\n" +
                "Игра и мука\n" +
                "Натянутая тетива\n" +
                "Тугого лука."));
        binding.imageView.setImageResource(R.drawable.poet);
    }
}
