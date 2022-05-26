# Mock class similar a screenlockinpattern.java, que usei para explorar possibilidades de resolucao do exercicio.
# __author__ Guilherme Salgueiro


# Os passos para a logica de resolucao foram os seguintes:
# Nesta classe, os pontos sao representados como um array de ints, com apenas duas posicoes,em que a primeira representa
# a linha, e a segunda posicao representa a coluna. Uma representacao visual da matriz seria entao:

# [1.1] [1.2] [1.3]
# [2.1] [2.2] [2.3]
# [3.1] [3.2] [3.3]

# funcao que identifica quais pontos deixam de ter certa navegacao, para evitar que se ultrapasse os limites da matriz,
# por exemplo:
# todos os pontos [1.x] nao podem ir para Norte;
#todos os pontos  [x.1] nao podem ir para Oeste.
def whatsForbiden(point):
    forbiden = []
    if point[0] == 1:
        forbiden.append("N")
    elif point[0] == 2:
        forbiden.append("NN")
        forbiden.append("SS")
    elif point[0] == 3:
        forbiden.append("S")

    if point[1] == 1:
        forbiden.append("O")
    elif point[1] == 2:
        forbiden.append("EE")
        forbiden.append("OO")
    elif point[1] == 3:
        forbiden.append("E")

    return forbiden

# funcao onde se identifica todos os sentidos de navegacao possiveis, e aplicam-se as proibicoes definidas em "whatsForbiden"
# assim, se dentro das direcoes, o ponto tiver proibicoes que incluam alguma letra como "N" ou "S", essas possibilidades sao removidas
# e ficamos apenas com as alternativas de navegacao possiveis.
def possibleWays(point, history):
    forbiden = whatsForbiden(point)
    print("neste ponto, as direcoes proibidas sao: " + str(forbiden))
    print("o historico atual: " + str(history))

    directions = ["N", "S", "E", "O", "NE", "NNE", "NEE", "NO", "NNO", "NOO", "SE", "SSE", "SEE", "SO", "SSO", "SOO"]

    for x in forbiden:
        i = 0
        while i < len(directions):
            if x in directions[i]:
                directions.pop(i)
            else:
                i = i + 1

    print("as direcoes permitidas sao apenas: " + str(directions))

    moves = []
# ciclo que aplica a logica/matematica de navegacao de acordo com a referencia cardinal, por exemplo:
# o ponto [2,1] poder ir para norte ("N") significa que se vai subtrair 1 ao valor correspondente a linha,
# passando entao a ser [1,1]

    for x in directions:

        move = point.copy()
        for d in x:

            if d == "N":
                move[0] = move[0] - 1
            elif d == "S":
                move[0] = move[0] + 1
            elif d == "E":
                move[1] = move[1] + 1
            elif d == "O":
                move[1] = move[1] - 1

        if move not in history:
            moves.append(move)

    print("O array de movimentos possiveis: " + str(moves))

    return moves

# por fim, esta funcao vai pegar no ponto de partida (point), no tamanho do padrao (l)
# e no historico de pontos ja visitados, e aplica recursao para determinar o numero de padroes
# de acordo com os parametros atribuidos.
def countPatternsAux(point, l, history):
    if l == 1:
        return 1

    patterns = 0
    pWays = possibleWays(point, history)
    history.append(point)
    for nMove in pWays:
        patterns += countPatternsAux(nMove, l - 1, history.copy())

    return patterns

# funcao que devolve o valor calculado em countPatternAux, o numero de padroes
def countPatterns(point, l):
    return countPatternsAux(point, l, [])

# Neste print pode se testar o funcionamento do codigo, em que um ponto deve ser representado por
# [x, y] em que 1 <= x <= 9 e 1 <= y <= 9 .  e l (length) 1 <= l <= 9 .
# por ser apenas um codigo de "rascunho", esta regra nao esta
# explicitamente definida aqui, como esta no codigo em java.
print(countPatterns([1, 3], 2))