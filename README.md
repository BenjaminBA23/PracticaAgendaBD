# 📆 Agenda Personal Gráfica en Java

Este proyecto es una aplicación de escritorio en Java Swing que permite gestionar contactos y eventos personales, con persistencia en base de datos SQL Server y arquitectura en capas.

## 🛠 Tecnologías

- Java 8+
- NetBeans 16+ (Ant Project)
- SQL Server 2022
- JDBC
- Swing (JFrame, JDialog, JTable, JComboBox)
- Git & GitHub

## 🧱 Estructura del Proyecto

/modelo → Clases Contacto y Evento
/dao → Acceso a base de datos (JDBC)
/servicio → Lógica de negocio (validaciones, flujos)
/ui → Interfaces gráficas: ventanas y formularios

markdown
Copiar
Editar

## ✅ Funcionalidades

- CRUD de contactos (crear, editar, eliminar)
- CRUD de eventos vinculados a contactos
- Filtro en tiempo real de contactos
- Validaciones de campos vacíos
- Tabla de eventos con nombre del contacto
- Manejo de errores con mensajes descriptivos

## 🧪 Base de Datos

- Tabla `contactos`  
- Tabla `eventos` con clave foránea a `contactos`

Incluye script `script.sql` para generar las tablas.

## 🚀 Ejecución

1. Abrir con NetBeans como proyecto Ant.
2. Configurar `ConectorBD.java` con los datos de tu base de datos.
3. Ejecutar `VentanaPrincipal.java`.
4. Interactuar con contactos y eventos.

## ✍ Autor
-Benjamín Bolaños
-Pamela Espinoza
-Alonso Morales

Desarrollado como parte del curso **Programación I**.
