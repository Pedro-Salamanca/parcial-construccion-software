import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
  * FASE ACTUAL: Día 2 - Integrante 2 (Cierre y Validación Final)
 * Contenido del avance:
 * - Verificación de los 8 botones de operación y conversión.
 * - Validaciones de campos vacíos, valores no numéricos y división por cero.
 * - Ajuste del botón de limpieza.
 */

public class VentanaPrincipal extends JFrame implements ActionListener {

    // --- Componentes: Módulo Matemático ---
    private JTextField txtNum1;
    private JTextField txtNum2;
    private JTextField txtResMatematicas;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;

    // --- Componentes: Módulo Temperatura ---
    private JTextField txtTemperatura;
    private JTextField txtResTemperatura;
    private JButton btnCelsiusAFahrenheit;
    private JButton btnFahrenheitACelsius;

    // --- Componentes: Módulo Moneda ---
    private JTextField txtMoneda;
    private JTextField txtResMoneda;
    private JButton btnUsdACop;
    private JButton btnCopAUsd;

    // --- Componente: Botón de Limpieza ---
    private JButton btnLimpiarTodo;

    public VentanaPrincipal() {
        // Configuración básica de la ventana principal
        setTitle("Sistema de Operaciones y Conversiones - TdeA");
        setSize(580, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setResizable(false);

        // Panel contenedor principal con distribución vertical
        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // Título de la aplicación
        JLabel lblTitulo = new JLabel("Panel de Operaciones y Conversiones", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelContenedor.add(lblTitulo);
        panelContenedor.add(Box.createRigidArea(new Dimension(0, 15)));

        // Construcción y adición de cada sección
        panelContenedor.add(crearPanelMatematicas());
        panelContenedor.add(Box.createRigidArea(new Dimension(0, 12)));
        panelContenedor.add(crearPanelTemperatura());
        panelContenedor.add(Box.createRigidArea(new Dimension(0, 12)));
        panelContenedor.add(crearPanelMoneda());
        panelContenedor.add(Box.createRigidArea(new Dimension(0, 15)));

        // Botón general de limpieza
        btnLimpiarTodo = new JButton("Limpiar Todos los Campos");
        btnLimpiarTodo.setFont(new Font("Arial", Font.BOLD, 12));
        btnLimpiarTodo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLimpiarTodo.addActionListener(this);
        panelContenedor.add(btnLimpiarTodo);

        add(panelContenedor);
    }

    /**
     * Construye el módulo de Operaciones Matemáticas.
     * Cumple con la Condición 7: indica exactamente dónde ingresar los dos números.
     */
    private JPanel crearPanelMatematicas() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "1. Operaciones Matemáticas",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 13),
                new Color(33, 85, 163)));

        // Subpanel para ingreso de datos
        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 8, 8));
        panelEntrada.add(new JLabel("Primer número:"));
        txtNum1 = new JTextField();
        panelEntrada.add(txtNum1);

        panelEntrada.add(new JLabel("Segundo número:"));
        txtNum2 = new JTextField();
        panelEntrada.add(txtNum2);

        // Subpanel para botones de operación
        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 8, 8));
        btnSumar = new JButton("Sumar");
        btnRestar = new JButton("Restar");
        btnMultiplicar = new JButton("Multiplicar");
        btnDividir = new JButton("Dividir");

        btnSumar.addActionListener(this);
        btnRestar.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnDividir.addActionListener(this);

        panelBotones.add(btnSumar);
        panelBotones.add(btnRestar);
        panelBotones.add(btnMultiplicar);
        panelBotones.add(btnDividir);

        // Subpanel para visualización del resultado
        JPanel panelResultado = new JPanel(new BorderLayout(5, 5));
        panelResultado.add(new JLabel("Resultado Matemático: "), BorderLayout.WEST);
        txtResMatematicas = new JTextField();
        txtResMatematicas.setEditable(false); // Solo lectura
        txtResMatematicas.setBackground(new Color(245, 245, 245));
        txtResMatematicas.setFont(new Font("Arial", Font.BOLD, 13));
        panelResultado.add(txtResMatematicas, BorderLayout.CENTER);

        panel.add(panelEntrada, BorderLayout.NORTH);
        panel.add(panelBotones, BorderLayout.CENTER);
        panel.add(panelResultado, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Construye el módulo de Conversión de Temperatura.
     * Delimita el campo de entrada exclusivo para grados.
     */
    private JPanel crearPanelTemperatura() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "2. Conversión de Temperatura",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 13),
                new Color(180, 70, 20)));

        // Subpanel de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(1, 2, 8, 8));
        panelEntrada.add(new JLabel("Grados a convertir:"));
        txtTemperatura = new JTextField();
        panelEntrada.add(txtTemperatura);

        // Subpanel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 8, 8));
        btnCelsiusAFahrenheit = new JButton("°C a °F");
        btnFahrenheitACelsius = new JButton("°F a °C");

        btnCelsiusAFahrenheit.addActionListener(this);
        btnFahrenheitACelsius.addActionListener(this);

        panelBotones.add(btnCelsiusAFahrenheit);
        panelBotones.add(btnFahrenheitACelsius);

        // Subpanel de resultado
        JPanel panelResultado = new JPanel(new BorderLayout(5, 5));
        panelResultado.add(new JLabel("Temperatura convertida: "), BorderLayout.WEST);
        txtResTemperatura = new JTextField();
        txtResTemperatura.setEditable(false);
        txtResTemperatura.setBackground(new Color(245, 245, 245));
        txtResTemperatura.setFont(new Font("Arial", Font.BOLD, 13));
        panelResultado.add(txtResTemperatura, BorderLayout.CENTER);

        panel.add(panelEntrada, BorderLayout.NORTH);
        panel.add(panelBotones, BorderLayout.CENTER);
        panel.add(panelResultado, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Construye el módulo de Conversión de Moneda.
     * Informa la tasa fija requerida ($3200 COP = 1 USD).
     */
    private JPanel crearPanelMoneda() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "3. Conversión de Moneda (Tasa fija: 1 USD = $3.200 COP)",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 13),
                new Color(25, 120, 50)));

        // Subpanel de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(1, 2, 8, 8));
        panelEntrada.add(new JLabel("Monto a convertir:"));
        txtMoneda = new JTextField();
        panelEntrada.add(txtMoneda);

        // Subpanel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 8, 8));
        btnUsdACop = new JButton("USD a COP");
        btnCopAUsd = new JButton("COP a USD");

        btnUsdACop.addActionListener(this);
        btnCopAUsd.addActionListener(this);

        panelBotones.add(btnUsdACop);
        panelBotones.add(btnCopAUsd);

        // Subpanel de resultado
        JPanel panelResultado = new JPanel(new BorderLayout(5, 5));
        panelResultado.add(new JLabel("Valor convertido: "), BorderLayout.WEST);
        txtResMoneda = new JTextField();
        txtResMoneda.setEditable(false);
        txtResMoneda.setBackground(new Color(245, 245, 245));
        txtResMoneda.setFont(new Font("Arial", Font.BOLD, 13));
        panelResultado.add(txtResMoneda, BorderLayout.CENTER);

        panel.add(panelEntrada, BorderLayout.NORTH);
        panel.add(panelBotones, BorderLayout.CENTER);
        panel.add(panelResultado, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Método auxiliar para validar que un campo no esté vacío y contenga un valor numérico válido.
     * Muestra alertas en pantalla si se detectan anomalías.
     */
    private Double validarCampoNumerico(JTextField campo, String nombreCampo) {
        String texto = campo.getText().trim();

        // Validación: campo vacío
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El campo '" + nombreCampo + "' no puede estar vacío.",
                    "Campo requerido",
                    JOptionPane.WARNING_MESSAGE);
            campo.requestFocus();
            return null;
        }

        // Validación: tipo numérico (sin letras ni caracteres especiales)
        try {
            return Double.parseDouble(texto.replace(',', '.'));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El valor ingresado en '" + nombreCampo + "' debe ser un número válido.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
            campo.requestFocus();
            return null;
        }
    }

    /**
     * Gestión centralizada de eventos para todos los botones de la aplicación.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();

        // -------------------------------------------------------------
        // OPERACIONES MATEMÁTICAS (Implementadas por Integrante 1 - Día 1)
        // -------------------------------------------------------------
        if (origen == btnSumar || origen == btnRestar || origen == btnMultiplicar || origen == btnDividir) {
            Double num1 = validarCampoNumerico(txtNum1, "Primer número");
            if (num1 == null) return;

            Double num2 = validarCampoNumerico(txtNum2, "Segundo número");
            if (num2 == null) return;

            double resultado = 0;

            if (origen == btnSumar) {
                resultado = num1 + num2;
                txtResMatematicas.setText(String.format("%.2f", resultado));
            } else if (origen == btnRestar) {
                resultado = num1 - num2;
                txtResMatematicas.setText(String.format("%.2f", resultado));
            } else if (origen == btnMultiplicar) {
                resultado = num1 * num2;
                txtResMatematicas.setText(String.format("%.2f", resultado));
            } else if (origen == btnDividir) {
                // Validación obligatoria: evitar división por cero
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this,
                            "No es posible realizar una división por cero.",
                            "Error Aritmético",
                            JOptionPane.ERROR_MESSAGE);
                    txtResMatematicas.setText("Indefinido");
                    return;
                }
                resultado = num1 / num2;
                txtResMatematicas.setText(String.format("%.4f", resultado));
            }
            return;
        }

        // -------------------------------------------------------------
        // CONVERSIÓN DE TEMPERATURA (Implementado por Integrante 2 - Día 1)
        // -------------------------------------------------------------
        if (origen == btnCelsiusAFahrenheit || origen == btnFahrenheitACelsius) {
            Double temp = validarCampoNumerico(txtTemperatura, "Grados a convertir");
            if (temp == null) return;

            double resultado = 0;
            if (origen == btnCelsiusAFahrenheit) {
                resultado = (temp * 9.0 / 5.0) + 32.0;
                txtResTemperatura.setText(String.format("%.2f °F", resultado));
            } else if (origen == btnFahrenheitACelsius) {
                resultado = (temp - 32.0) * 5.0 / 9.0;
                txtResTemperatura.setText(String.format("%.2f °C", resultado));
            }
            return;
        }

        // -------------------------------------------------------------
        // CONVERSIÓN DE MONEDA (Implementado por Integrante 1 - Día 2)
        // -------------------------------------------------------------
        if (origen == btnUsdACop || origen == btnCopAUsd) {
            Double monto = validarCampoNumerico(txtMoneda, "Monto a convertir");
            if (monto == null) return;

            // Validación de valor no negativo para montos de dinero
            if (monto < 0) {
                JOptionPane.showMessageDialog(this,
                        "El monto de dinero no puede ser un valor negativo.",
                        "Valor inválido",
                        JOptionPane.WARNING_MESSAGE);
                txtMoneda.requestFocus();
                return;
            }

            // Tasa de cambio fija obligatoria según especificación: 1 USD = 3.200 COP
            final double TASA_FIJA_DOLAR = 3200.0;
            double resultado = 0;

            if (origen == btnUsdACop) {
                resultado = monto * TASA_FIJA_DOLAR;
                txtResMoneda.setText(String.format("$ %,.2f COP", resultado));
            } else if (origen == btnCopAUsd) {
                resultado = monto / TASA_FIJA_DOLAR;
                txtResMoneda.setText(String.format("$ %,.2f USD", resultado));
            }
            return;
        }

        // -------------------------------------------------------------
        // BOTÓN LIMPIAR TODO
        // -------------------------------------------------------------
        if (origen == btnLimpiarTodo) {
            txtNum1.setText("");
            txtNum2.setText("");
            txtResMatematicas.setText("");
            txtTemperatura.setText("");
            txtResTemperatura.setText("");
            txtMoneda.setText("");
            txtResMoneda.setText("");
            txtNum1.requestFocus();
        }
    }

    public static void main(String[] args) {
        // Ejecución en el hilo gráfico de Swing
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
