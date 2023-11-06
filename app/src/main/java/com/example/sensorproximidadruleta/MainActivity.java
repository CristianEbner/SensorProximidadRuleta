package com.example.sensorproximidadruleta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.hardware.Sensor;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

//la implementacion SensorEventListener debe proporcionar implementaciones para los metodos onSensorChanged y onAccracyChanged
public abstract class MainActivity extends AppCompatActivity implements SensorEventListener {
    ConstraintLayout cl;//el constraintlayout que es el contenedor
    TextView texto;//el textview que se utilizara para mostrar un mensaje en pantalla
    SensorManager sm;//objeto que se utilizara para gestionar los sensores del dispositivo
    Sensor sensor;//obtiene  el sensor de proximidad
    ImageView ruleta;//objeto para generar angulos aleatorios para la rotacion de la ruleta
    Random random;//objeto para generar angulos aleatorios  para la rotacion de la ruleta
    int angulo;
    boolean restart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ruleta=findViewById(R.id.ruleta);
        cl=findViewById(R.id.Caja);
        texto=findViewById(R.id.txt_texto);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener((SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        random=new Random();
    }


}