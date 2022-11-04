
    const val red = "\u001b[31m"
    const val green = "\u001b[32m"
    const val blue = "\u001b[34m"
    const val reset = "\u001b[0m"
    var tam = 10
    var minas = 20
    var minaRoja = red + "X" + reset
    var minaAzul = blue + "X" + reset

fun main() {

    var campo = Array(tam) {Array<String>(tam) {""} }
    var campoOculto = Array(tam) {Array<String>(tam) {"_"} }
    var campoFinal = Array(tam) {Array<String>(tam) {"_"} }
    var decision = 0

    campo = crearCampo(campo)
    campoFinal = crearCampoFinal(campo, campoFinal)
    imprimirCampo(campoOculto)

    do {
        do {
            println("\n1. Desvelar casilla")
            println("2. Poner mina")
            decision = readln().toInt()
        } while (decision != 1 && decision!= 2)
        if (decision == 1) {
            seleccionCasilla(campo, campoOculto)
        } else ponerMina(campoOculto)
    } while (campoOculto[0][0] != "" && !(campoOculto.contentDeepEquals(campoFinal)))

    if (campoOculto.contentDeepEquals(campoFinal)) {
        println("$green\nGANASTE$reset")
    }
}

fun crearCampo(campo: Array<Array<String>>): Array<Array<String>> {

    var cont = 0
    var contS: String

    do {
        var randI = (0 until tam).random()
        var randJ = (0 until tam).random()

        if (campo[randI][randJ] == "") {
            campo[randI][randJ] = minaRoja
            cont++
        }
    } while (cont != minas)

    cont = 0

    for (i in campo.indices) {
        for (j in campo[i].indices) {
            if (campo[i][j] != minaRoja) {
                if (i == 0 || j == 0 || i == tam-1 || j == tam-1) {
                    if (i == 0) {
                        when (j) {
                            0 -> {
                                if (campo[i][j + 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j + 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j] == minaRoja) {
                                    cont++
                                }
                                contS = cont.toString()
                                campo[i][j] = contS
                            }

                            in 1 until tam-1 -> {
                                if (campo[i][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j + 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i][j + 1] == minaRoja) {
                                    cont++
                                }
                                contS = cont.toString()
                                campo[i][j] = contS
                            }

                            tam-1 -> {
                                if (campo[i][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j] == minaRoja) {
                                    cont++
                                }
                                contS = cont.toString()
                                campo[i][j] = contS
                            }
                        }
                        cont = 0
                    }
                    if (j == 0) {
                        when (i) {
                            in 1 until tam-1 -> {
                                if (campo[i - 1][j] == minaRoja) {
                                    cont++
                                }
                                if (campo[i - 1][j + 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i][j + 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j + 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j] == minaRoja) {
                                    cont++
                                }
                                contS = cont.toString()
                                campo[i][j] = contS
                            }

                            tam-1 -> {
                                if (campo[i - 1][j] == minaRoja) {
                                    cont++
                                }
                                if (campo[i - 1][j + 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i][j + 1] == minaRoja) {
                                    cont++
                                }
                                contS = cont.toString()
                                campo[i][j] = contS
                            }
                        }
                        cont = 0
                    }
                    if (i == tam-1) {
                        when (j) {
                            in 1 until tam-1 -> {
                                if (campo[i][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i - 1][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i - 1][j] == minaRoja) {
                                    cont++
                                }
                                if (campo[i - 1][j + 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i][j + 1] == minaRoja) {
                                    cont++
                                }
                                contS = cont.toString()
                                campo[i][j] = contS
                            }

                            tam-1 -> {
                                if (campo[i][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i - 1][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i - 1][j] == minaRoja) {
                                    cont++
                                }
                                contS = cont.toString()
                                campo[i][j] = contS
                            }
                        }
                        cont = 0
                    }
                    if (j == tam-1) {
                        when (i) {
                            in 1 until tam-1 -> {
                                if (campo[i - 1][j] == minaRoja) {
                                    cont++
                                }
                                if (campo[i - 1][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j - 1] == minaRoja) {
                                    cont++
                                }
                                if (campo[i + 1][j] == minaRoja) {
                                    cont++
                                }
                                contS = cont.toString()
                                campo[i][j] = contS
                            }
                        }
                        cont = 0
                    }
                } else {
                    if (campo[i - 1][j - 1] == minaRoja) {
                        cont++
                    }
                    if (campo[i][j - 1] == minaRoja) {
                        cont++
                    }
                    if (campo[i + 1][j - 1] == minaRoja) {
                        cont++
                    }
                    if (campo[i + 1][j] == minaRoja) {
                        cont++
                    }
                    if (campo[i + 1][j + 1] == minaRoja) {
                        cont++
                    }
                    if (campo[i][j + 1] == minaRoja) {
                        cont++
                    }
                    if (campo[i - 1][j + 1] == minaRoja) {
                        cont++
                    }
                    if (campo[i - 1][j] == minaRoja) {
                        cont++
                    }
                    contS = cont.toString()
                    campo[i][j] = contS
                    cont = 0
                }
            }
        }
    }

    return campo
}

fun crearCampoFinal(campo: Array<Array<String>>, campoFinal: Array<Array<String>>): Array<Array<String>> {

    for (i in campoFinal.indices) {
        for (j in campoFinal[i].indices) {
            if (campo[i][j] != minaRoja) {
                campoFinal[i][j] = campo[i][j]
            } else campoFinal[i][j] = minaAzul
        }
    }
    return campoFinal
}

fun imprimirCampo(campo: Array<Array<String>>) {

    var cont = 1
    var contS = ""
    var caracter = 'A'

    print("    ")
    for (i in 0 until tam) {
        print("$caracter  ")
        caracter++
    }
    println()

    for (i in campo.indices) {

        contS = cont.toString()
        if (contS.length == 1) {
            print("$contS   ")
        } else print("$contS  ")
        cont++

        for (j in campo[i].indices) {
            print("${campo[i][j]}  ")
        }
        println()
    }
}

fun seleccionCasilla(campo: Array<Array<String>>, campoOculto: Array<Array<String>>): Array<Array<String>> {

    var letra = ""
    var letraC = ' '
    var letraN = 0
    var numero = 0
    var rango = 65 until 65 + tam
    var cont = 0

    do {
        print("\nLetra: ")
        letra = readln().uppercase().toString()
        letraC = letra[0]
        letraN = letraC.code

        if (letraN !in rango) {
            println("La letra no es válida.")
        }
    } while (letraN !in rango)

    for (i in rango) {
        if (letraN == i) {
            letraN = cont
        }
        cont++
    }

    do {
        print("Número: ")
        numero = readln().toInt()
        if (numero !in (1..tam)) {
            println("El número no es válido.")
        }
    } while (numero !in (1..tam))

    numero--

    campoOculto[numero][letraN] = campo[numero][letraN]

    if (campoOculto[numero][letraN] == "0") {

        if (numero == 0 || numero == tam-1 || letraN == 0 || letraN == tam-1) {
            when (numero) {
                0 -> {
                    if (letraN == 0) {
                        campoOculto[numero][letraN + 1] = campo[numero][letraN + 1]
                        campoOculto[numero + 1][letraN + 1] = campo[numero + 1][letraN + 1]
                        campoOculto[numero + 1][letraN] = campo[numero + 1][letraN]
                    }
                    if (letraN in 1 until tam-1) {
                        campoOculto[numero][letraN - 1] = campo[numero][letraN - 1]
                        campoOculto[numero + 1][letraN - 1] = campo[numero + 1][letraN - 1]
                        campoOculto[numero + 1][letraN] = campo[numero + 1][letraN]
                        campoOculto[numero + 1][letraN + 1] = campo[numero + 1][letraN + 1]
                        campoOculto[numero][letraN + 1] = campo[numero][letraN + 1]
                    }
                    if (letraN == tam-1) {
                        campoOculto[numero][letraN - 1] = campo[numero][letraN - 1]
                        campoOculto[numero + 1][letraN - 1] = campo[numero + 1][letraN - 1]
                        campoOculto[numero + 1][letraN] = campo[numero + 1][letraN]
                    }
                }
                tam-1 -> {
                    if (letraN == 0) {
                        campoOculto[numero - 1][letraN] = campo[numero - 1][letraN]
                        campoOculto[numero - 1][letraN + 1] = campo[numero - 1][letraN + 1]
                        campoOculto[numero][letraN + 1] = campo[numero][letraN + 1]
                    }
                    if (letraN in 1 until tam-1) {
                        campoOculto[numero][letraN - 1] = campo[numero][letraN - 1]
                        campoOculto[numero - 1][letraN - 1] = campo[numero - 1][letraN - 1]
                        campoOculto[numero - 1][letraN] = campo[numero - 1][letraN]
                        campoOculto[numero - 1][letraN + 1] = campo[numero - 1][letraN + 1]
                        campoOculto[numero][letraN + 1] = campo[numero][letraN + 1]
                    }
                    if (letraN == tam-1) {
                        campoOculto[numero][letraN - 1] = campo[numero][letraN - 1]
                        campoOculto[numero - 1][letraN - 1] = campo[numero - 1][letraN - 1]
                        campoOculto[numero - 1][letraN] = campo[numero - 1][letraN]
                    }
                }
            }
            when (letraN) {
                0 -> {
                    if (numero in 1 until tam-1) {
                        campoOculto[numero - 1][letraN] = campo[numero - 1][letraN]
                        campoOculto[numero - 1][letraN + 1] = campo[numero - 1][letraN + 1]
                        campoOculto[numero][letraN + 1] = campo[numero][letraN + 1]
                        campoOculto[numero + 1][letraN + 1] = campo[numero + 1][letraN + 1]
                        campoOculto[numero + 1][letraN] = campo[numero + 1][letraN]
                    }
                }
                tam-1 -> {
                    if (numero in 1 until tam-1) {
                        campoOculto[numero - 1][letraN] = campo[numero - 1][letraN]
                        campoOculto[numero - 1][letraN - 1] = campo[numero - 1][letraN - 1]
                        campoOculto[numero][letraN - 1] = campo[numero][letraN - 1]
                        campoOculto[numero + 1][letraN - 1] = campo[numero - 1][letraN - 1]
                        campoOculto[numero + 1][letraN] = campo[numero + 1][letraN]
                    }
                }
            }

        } else {
            campoOculto[numero - 1][letraN - 1] = campo[numero - 1][letraN - 1]
            campoOculto[numero][letraN - 1] = campo[numero][letraN - 1]
            campoOculto[numero + 1][letraN - 1] = campo[numero + 1][letraN - 1]
            campoOculto[numero + 1][letraN] = campo[numero + 1][letraN]
            campoOculto[numero + 1][letraN + 1] = campo[numero + 1][letraN + 1]
            campoOculto[numero][letraN + 1] = campo[numero][letraN + 1]
            campoOculto[numero - 1][letraN + 1] = campo[numero - 1][letraN + 1]
            campoOculto[numero - 1][letraN] = campo[numero - 1][letraN]
        }
    }

    println()
    imprimirCampo(campoOculto)

    if (campoOculto[numero][letraN] == minaRoja) {
        println("$red\nTOCASTE UNA MINA$reset")
        for (i in campoOculto.indices) {
            for (j in campoOculto[i].indices) {
                campoOculto[i][j] = ""
            }
        }
    }

    return campoOculto
}

fun ponerMina(campoOculto: Array<Array<String>>): Array<Array<String>> {

    var letra = ""
    var letraC = ' '
    var letraN = 0
    var numero = 0
    var rango = 65 until 65 + tam
    var cont = 0

    do {
        print("\nLetra: ")
        letra = readln().uppercase().toString()
        letraC = letra[0]
        letraN = letraC.code

        if (letraN !in rango) {
            println("La letra no es válida.")
        }
    } while (letraN !in rango)

    for (i in rango) {
        if (letraN == i) {
            letraN = cont
        }
        cont++
    }

    do {
        print("Número: ")
        numero = readln().toInt()
        if (numero !in (1..tam)) {
            println("El número no es válido.")
        }
    } while (numero !in (1..tam))

    numero--

    campoOculto[numero][letraN] = minaAzul

    println()
    imprimirCampo(campoOculto)

    return campoOculto
}