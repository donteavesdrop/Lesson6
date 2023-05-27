package ru.mirea.zakharova.superherodb;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ru.mirea.zakharova.employeedb.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        SuperHeroDao superHeroDao = db.superHeroDao();
        SuperHero superHero = new SuperHero();
        superHero.id = 1;
        superHero.name = "Super Zip";
        superHero.power = 10000;
        // запись героев в базу
        superHeroDao.insert(superHero);
        // Загрузка всех героев
        List<SuperHero> superHeroes = superHeroDao.getAll();
        // Получение определенного героя с id = 1
        superHero = superHeroDao.getById(1);
        // Обновление полей объекта
        superHero.power = 20000;
        superHeroDao.update(superHero);
        Log.d(TAG, superHero.name + " " + superHero.power);
    }
}