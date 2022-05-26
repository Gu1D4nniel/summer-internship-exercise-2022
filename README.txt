ScreenLockinPattern - Guilherme Salgueiro
----------------------------------------------------------------------------------------=========----------------

Apresento aqui a minha resolucao para o problema proposto pela Premium Minds, em que
o objetivo era calcular o numero de padroes possiveis de se formar, indicando um ponto
de partida e o tamanho do padrao. A minha proposta de resolucao foi a seguinte:

1 - Certificar que os parametros do metodo countPatternsFrom cumprem as regras relativamente 
a limitacao de imput. Ambos os metodos dispoem de clausulas "try-catch" para melhor informar 
o utilizador do input correto, e as excessoes que possam vir a ser levantadas.

2 - Criar uma estrategia de validacao dos pontos no padrao.
O objetivo e avaliar, a partir do ponto de partida, que pontos candidatos a ser os proximos sao 
validos via mecanismo de coordenadas, e manipulando correspondentemente a navegacao na matriz segundo essas
 coordenadas enquanto cada ponto que ja tenha sido usado no padrao seja acrescentado a uma lista, para
evitar repeticoes, e permitir que se possa passar por cima desse ponto caso ele ja tenha sido selecionado.
(A logica ainda nao foi completamente desenvolvida, e por isso ainda nao passa nos testes.


*OBS*: Alguns reparos que considero importantes de mencionar:

1 - Os comentarios no codigo estao todos escritos em ingles, para manter o mesmo idioma que os elementos do
programa e os comentarios ja existentes tinham.

2 -  Neste projeto, usei pela primeira vez em termos praticos a ferramenta "Maven" para controlo de
dependencias, uma vez que, durante o meu percurso academico, foi abordada muito brevemente em apenas uma ca-
deira do curso, ja no terceiro e ultimo ano da licencitura.

3 - Neste projeto, tive contacto pela primeira vez com a interface "Future<T>" para chamadas assincronas dentro
de um programa, uma vez que, durante o meu percurso academico, nao tera sido abordado/usado em nenhuma cadeira
do curso. Este ponto e o anterior tornaram o processo de desenvolvimento mais desafiador, mas ao mesmo tempo
ajudaram a enriquecer o meu conhecimento em desenvolvimento em Java.

4 - Tomei a liberdade de adicionar uma versao em Python de uma classe similar a ScreenLockinPattern.java, e que
 funciona da maneira que se pretende que o ScreenLOckinPattern.hava funcione, numa pasta separada, onde foi 
mais facil para mim desenvolver a logica para a resolucao do problema, de uma forma mais simplificada
e tirando vantagem da flexibilidade do python, e tentei de seguida aplicar uma "traducao" para java (a qual ainda esta
incompleta) no entanto, peco que caso considerem, podem ver o codigo a funcionar no ficheiro "ScreenLockinPattern.py"
que se encontra na pasta ScreenLockinPattern_logica.
-----------------------------------------------------------------------------------------------------------------

Tendo sido feitas estas observacoes, agradeco desde ja pela oportunidade de participar neste processo de selecao,
e espero continuar a aprender e crescer enquanto programador junto da Premium Minds.

With Best Regards
Guilherme Salgueiro