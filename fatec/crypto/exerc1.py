"""
Created on Tue Aug 14 20:17:56 2018
Aula de Cripto
Lista de Exercícios
@author: enrique
"""

##################################

#A Cesar o que e de Cesar. Todos os caminhos levam a Roma. 


#criptografando a frase

text = 'ACESAROQUEEDECESARTODOSOSCAMINHOSLEVAMAROMA'
k = 7
crip = ''

for i in text:
    if (ord(i) + k) > 90:
        crip += chr((ord(i) + k) - 26)
    else:
        crip += chr((ord(i) + k))

crip

##################################
#decriptografando a frase

text1 = 'HJLZHYVXBLLKLJLZHYAVKVZVZJHTPUOVZSLCHTHYVTH'
k = 7
decrip = ''

for i in text1:
    if (ord(i) - k) < 65:
        decrip += chr((ord(i) - k) + 26)
    else:
        decrip += chr((ord(i) - k))

decrip

##################################
