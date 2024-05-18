package com.example.t5_a3_landerostrujillojudith;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private double primerValor = Double.NaN;
    private double segundoValor;
    private char operacionActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSimbolo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editTextText);

        // Configurar botones numéricos y de punto
        configurarBotonesNumericos();

        // Configurar botones de operación
        configurarBotonesOperacion();
    }

    private void configurarBotonesNumericos() {
        Button btn0 = findViewById(R.id.btnCero);
        Button btn1 = findViewById(R.id.btnUno);
        Button btn2 = findViewById(R.id.btnDos);
        Button btn3 = findViewById(R.id.btnTres);
        Button btn4 = findViewById(R.id.btnCuatro);
        Button btn5 = findViewById(R.id.btnCinco);
        Button btn6 = findViewById(R.id.btnSeis);
        Button btn7 = findViewById(R.id.btnSiete);
        Button btn8 = findViewById(R.id.btnOcho);
        Button btn9 = findViewById(R.id.btnNueve);
        Button btnPunto = findViewById(R.id.btnPunto);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("9");
            }
        });
        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append(".");
            }
        });
    }

    private void configurarBotonesOperacion() {
        Button btnMas = findViewById(R.id.btnMas);
        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnMultiplicacion = findViewById(R.id.btnMultiplicaicon);
        Button btnDivision = findViewById(R.id.btnDivision);
        Button btnIgual = findViewById(R.id.btnIgual);
        Button btnBorrar = findViewById(R.id.butBorrar);
        Button btnRaiz = findViewById(R.id.btnRaiz);
        Button btnCuadrado = findViewById(R.id.btnX2);
        Button btnPorcentaje = findViewById(R.id.btnPorcentaje);
        Button btnMasMenos = findViewById(R.id.btnMasMenos);

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                establecerOperacion('+');
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                establecerOperacion('-');
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                establecerOperacion('*');
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                establecerOperacion('/');
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                primerValor = Double.NaN;
                segundoValor = Double.NaN;
                operacionActual = '\0';
            }
        });

        btnRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacionUnaria('√');
            }
        });

        btnCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacionUnaria('²');
            }
        });

        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacionUnaria('%');
            }
        });

        btnMasMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacionUnaria('±');
            }
        });
    }

    private void establecerOperacion(char operacion) {
        try {
            if (!Double.isNaN(primerValor)) {
                segundoValor = Double.parseDouble(editText.getText().toString());
                calcularResultado();
            } else {
                primerValor = Double.parseDouble(editText.getText().toString());
            }
            operacionActual = operacion;
            editText.setText("");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Entrada no válida", Toast.LENGTH_SHORT).show();
        }
    }

    private void calcularResultado() {
        try {
            if (!Double.isNaN(primerValor)) {
                segundoValor = Double.parseDouble(editText.getText().toString());
                double resultado = 0;
                if (operacionActual == '+') {
                    resultado = primerValor + segundoValor;
                } else if (operacionActual == '-') {
                    resultado = primerValor - segundoValor;
                } else if (operacionActual == '*') {
                    resultado = primerValor * segundoValor;
                } else if (operacionActual == '/') {
                    if (segundoValor != 0) {
                        resultado = primerValor / segundoValor;
                    } else {
                        Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                editText.setText(String.valueOf(resultado));
                primerValor = Double.NaN;
                operacionActual = '\0';
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Entrada no válida", Toast.LENGTH_SHORT).show();
        }
    }

    private void calcularOperacionUnaria(char operacion) {
        try {
            double valor = Double.parseDouble(editText.getText().toString());
            double resultado = 0;
            if (operacion == '√') {
                resultado = Math.sqrt(valor);
            } else if (operacion == '²') {
                resultado = Math.pow(valor, 2);
            } else if (operacion == '%') {
                resultado = valor / 100;
            } else if (operacion == '±') {
                resultado = valor * -1;
            }
            editText.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Entrada no válida", Toast.LENGTH_SHORT).show();
        }
    }
}
