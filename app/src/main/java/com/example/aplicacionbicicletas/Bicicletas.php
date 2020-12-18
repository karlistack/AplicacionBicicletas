<?php

$server = "localhost";
$user = "root";
$pass = "clave";
$bd = "Bicicletas";

//Creamos la conexión
$conexion = mysqli_connect($server, $user, $pass,$bd)
or die("Ha sucedido un error inexperado en la conexion de la base de datos");

//generamos la consulta
$sql = "SELECT * FROM Bicicleta";
mysqli_set_charset($conexion, "utf8"); //formato de datos utf8

if(!$result = mysqli_query($conexion, $sql)) die();

$Bicicleta = array(); //creamos un array

while($row = mysqli_fetch_array($result))
{    $modelo=$row['modelo'];
     $empresa=$row['empresa'];
     $año=$row['año'];
     $imagen=$row['imagen'];
     $precio=$row['precio'];


    


    $Bicicleta[] = array('modelo'=> $modelo,'empresa'=> $empresa,'año'=> $año, 'imagen'=> $imagen,'precio'=> $precio);

}

$close = mysqli_close($conexion)
or die("Ha sucedido un error inexperado en la desconexion de la base de datos");


$json_string = json_encode($Bicicleta);

echo $json_string;

//Si queremos crear un archivo json, sería de esta forma:
/*
$file = 'clientes.json';
file_put_contents($file, $json_string);
*/


?>
