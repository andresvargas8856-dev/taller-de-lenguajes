# GymPower - Proyecto Swing NetBeans
## Resumen de Requerimientos Cubiertos

---

### 1. Tres ventanas navegables entre sí ✅
- **Inicio.java** → navega a InicioSesion y Registrarse
- **InicioSesion.java** → navega a MenuCliente o MenuEntrenador
- **MenuCliente.java** → navega a ListaMembresia, ConfirmarCita e Inicio
- **MenuEntrenador.java** → navega a Inicio
- **Registrarse.java** → navega a InicioSesion e Inicio
(Más de 3, todas conectadas entre sí)

---

### 2. Creación y uso de 2 clases (un estudiante) ✅
- **Cliente.java** — entidad del cliente con datos personales y credenciales
- **Entrenador.java** — entidad del entrenador con especialidad y credenciales
- Usadas en: InicioSesion, MenuCliente, MenuEntrenador, DataManager, etc.

---

### 3. Dos componentes no explicados en clase + tabla ✅
- **JSpinner** (`spnIntentos` en InicioSesion.java) — muestra el contador de intentos de login
- **JTable** (`tblCitas` en MenuCliente.java y MenuEntrenador.java) — muestra citas en formato tabla
- **JScrollPane** — envuelve la JTable para hacer scroll

---

### 4. Mínimo 8 métodos (un estudiante) ✅
En **DataManager.java** (solo en esa clase hay 11 métodos):
1. `cargarClientes()`
2. `guardarCliente()`
3. `buscarCliente()`
4. `usuarioExiste()`
5. `cargarEntrenadores()`
6. `guardarEntrenador()`
7. `buscarEntrenador()`
8. `cargarMembresias()`
9. `guardarMembresia()`
10. `obtenerMembresiaCliente()`
11. `cargarCitas()`
12. `guardarCita()`
13. `citasPorCliente()`
14. `citasPorEntrenador()`

---

### 5. Imágenes en botones ✅
- Implementado en `Inicio.java` → `cargarIconosBotones()`: carga `/recursos/login.png` y `/recursos/registro.png`
- Implementado en `InicioSesion.java` → `cargarIconoBoton()`: carga `/recursos/entrar.png`
- Implementado en `MenuCliente.java` → `cargarIconosBotones()`: carga íconos para los 3 botones
- Implementado en `MenuEntrenador.java` → `cargarIconosBotones()`: carga ícono de salir
- Si las imágenes no existen, los botones muestran solo texto (no crashea)
- **Para agregar imágenes**: crear carpeta `recursos/` en el proyecto y agregar PNG nombrados como se indica

---

### 6. Información guardada en archivos (un estudiante) ✅
- **clientes.csv** — persiste los datos de clientes registrados
- **membresias.csv** — persiste las membresias contratadas
- **citas.csv** — persiste las citas agendadas
- **entrenadores.csv** — persiste los entrenadores del gimnasio
Toda la lectura/escritura está centralizada en `DataManager.java`

---

### 7. Nombramiento de todos los componentes ✅
Todos los componentes tienen `.setName("nombreComponente")`. Ejemplos:
- `btnIniciarSesion`, `btnRegistrarse`, `lblTitulo` (Inicio.java)
- `txtUsuario`, `txtContrasena`, `spnIntentos`, `btnEntrar` (InicioSesion.java)
- `tblCitas`, `scrollCitas`, `lblSaludo`, `btnMembresia` (MenuCliente.java)

---

### 8. Comentarios en los métodos ✅
Todos los métodos tienen comentarios Javadoc (`/** ... */`) con:
- Descripción del método
- `@param` para cada parámetro
- `@return` cuando aplica

---

### Formato NetBeans .form ✅
Las siguientes clases mantienen el formato compatible con el Form Editor:
- `Inicio.java`, `InicioSesion.java`, `MenuCliente.java`
- `MenuEntrenador.java`, `Registrarse.java`, `ListaMembresias.java`

Todas incluyen:
- Encabezado de licencia
- Logger estático
- `initComponents()` con `@SuppressWarnings("unchecked")`
- `// <editor-fold>` y `// </editor-fold>`
- Bloque `// Variables declaration - do not modify`
- Método `main()` con configuración de Nimbus

---

### Archivos del proyecto
```
gympower/
├── Inicio.java          ← Ventana principal
├── InicioSesion.java    ← Login (JSpinner)
├── Registrarse.java     ← Registro de clientes
├── MenuCliente.java     ← Menu cliente (JTable)
├── MenuEntrenador.java  ← Menu entrenador (JTable)
├── ConfirmarCita.java   ← Agendar cita
├── ListaMembresia.java  ← Selección de plan
├── ListaMembresias.java ← (versión alternativa NetBeans)
├── Factura.java         ← Factura de membresia
├── Cliente.java         ← Modelo de datos
├── Entrenador.java      ← Modelo de datos
├── Cita.java            ← Modelo de datos
├── Membresia.java       ← Modelo de datos
└── DataManager.java     ← Acceso a archivos CSV
```
