
# 📚 Student Mate

**Student Mate** é uma aplicação Android desenvolvida em Java, criada para ajudar estudantes a organizar os seus estudos, rever conteúdos e acompanhar o seu progresso académico.

O principal objetivo da aplicação é proporcionar uma ferramenta simples e intuitiva que permita melhorar os hábitos de estudo através de flashcards, agendamento de revisões e estatísticas de aprendizagem.

## 🎯 Objetivos do Projeto

- Facilitar a organização dos conteúdos de estudo.
- Incentivar a revisão regular da matéria.
- Permitir a criação de flashcards personalizados.
- Acompanhar a evolução da aprendizagem.
- Ajudar os estudantes a manter uma rotina de estudo.
- Proporcionar uma experiência simples e acessível.

## 🚀 Funcionalidades

### 📝 1. Flashcards

A aplicação permite gerir cartões de estudo que ajudam na memorização de conteúdos.

Funcionalidades implementadas no código:

- Criar flashcards com perguntas e respostas.
- Associar cada flashcard a um tema.
- Consultar a resposta de um cartão.
- Marcar cartões como revistos.
- Contabilizar o número de revisões.
- Eliminar flashcards.

Os flashcards são apresentados numa lista, utilizando o componente RecyclerView.

### 📅 2. Cronograma de Revisões

Esta funcionalidade permite organizar as sessões de revisão.

Inclui:

- Seleção de uma data e hora para estudar.
- Opção de agendar uma revisão para o dia seguinte às 09:00.
- Identificação de cartões pendentes de revisão.
- Lógica de agendamento de lembretes.

O sistema considera pendentes os cartões que nunca foram revistos ou cuja última revisão ocorreu há mais de 24 horas.

### 📊 3. Estatísticas de Aprendizagem

A aplicação inclui um sistema de acompanhamento do progresso do estudante.

Permite calcular:

- Número total de flashcards por tema.
- Quantidade de cartões revistos.
- Percentagem de cartões revistos por tema.
- Percentagem global de progresso.

Os resultados são apresentados através de informação textual e de uma barra de progresso.

### 🔔 4. Notificações e Lembretes

O projeto inclui componentes para criar lembretes locais de estudo.

São utilizados:

- AlarmManager para agendamento de alarmes.
- BroadcastReceiver para receber os eventos.
- NotificationCompat para construir notificações.
- NotificationChannel para organizar as notificações.

A integração completa das notificações e o reagendamento após reiniciar o dispositivo ainda necessitam de melhorias.

### 🎯 5. Modo de Foco

O modo de foco foi pensado para permitir ao estudante concentrar-se exclusivamente na revisão da matéria.

Quando ativado, abre o ecrã dos flashcards com uma interface simplificada, ocultando o botão de criação de cartões e a barra superior.

### 🌙 6. Tema Claro e Escuro

O código inclui uma opção para alternar entre os modos claro e escuro, permitindo adaptar a interface às preferências do utilizador.

## 🛠️ Tecnologias Utilizadas

O Student Mate utiliza as seguintes tecnologias:

- **Java:** desenvolvimento da lógica da aplicação.
- **Android SDK:** funcionalidades do sistema operativo Android.
- **XML:** criação de interfaces e recursos gráficos.
- **AndroidX:** componentes de compatibilidade Android.
- **AppCompat:** suporte a atividades e funcionalidades modernas.
- **RecyclerView:** apresentação de listas de flashcards.
- **Material Components:** elementos visuais da interface.
- **Room:** solução de persistência local referenciada no código.
- **AlarmManager:** agendamento de lembretes.
- **NotificationCompat:** criação de notificações locais.

## 📂 Organização do Projeto

Os principais ficheiros atualmente disponíveis são:

### Classes Java

- `MainActivity.java` — Ecrã principal e navegação.
- `FlashcardsActivity.java` — Gestão dos flashcards.
- `Flashcard.java` — Modelo de dados dos cartões.
- `FlashcardAdapter.java` — Apresentação dos cartões.
- `CronogramActivity.java` — Agendamento de revisões.
- `StaticsActivity.java` — Estatísticas de aprendizagem.
- `AlarmUtils.java` — Agendamento de alarmes.
- `NotificationHelper.java` — Construção de notificações.
- `NotificationReceiver.java` — Receção de alarmes.
- `BootReceiver.java` — Estrutura para eventos de reinício.

### Ficheiros XML

- `activity_main.xml` — Interface principal.
- `activity_flashcards.xml` — Interface dos flashcards.
- `activity_cronogram.xml` — Interface do cronograma.
- `activity_statics.xml` — Interface das estatísticas.
- `dialog_add_card.xml` — Formulário de criação de cartões.
- `item_flashcard.xml` — Apresentação individual dos cartões.
- `menu.xml` — Menu de opções.
- `colors.xml` — Definição de cores.
- `strings.xml` — Recursos de texto.
- `styles.xml` e `themes.xml` — Estilos e temas da aplicação.
- `AndroidManifest.xml` — Configuração dos componentes Android.

## 💻 Como Obter o Projeto

O código-fonte encontra-se disponível publicamente no GitHub.

### 1. Clonar o repositório

```bash
git clone https://github.com/Simao-PB/Student_mate.git
```

### 2. Aceder à pasta

```bash
cd Student_mate
```

### 3. Preparar o ambiente

Para desenvolver e executar a aplicação, é recomendado utilizar:

- Android Studio.
- Java Development Kit (JDK).
- Android SDK.
- Emulador Android ou dispositivo físico.

**Nota:** O repositório contém atualmente os ficheiros Java e XML, mas ainda não apresenta a estrutura completa de um projeto Android Studio, incluindo os ficheiros de configuração Gradle e algumas classes de acesso à base de dados. É necessário completar esta estrutura e corrigir as integrações antes de compilar e executar a aplicação.

## 🔄 Funcionamento Previsto

O funcionamento da aplicação segue uma sequência simples:

1. O estudante abre o Student Mate.
2. Acede à secção de flashcards.
3. Cria cartões com perguntas, respostas e temas.
4. Consulta os cartões para estudar.
5. Marca os conteúdos que já reviu.
6. Consulta as estatísticas para acompanhar o progresso.
7. Agenda novas sessões de revisão.
8. Recebe lembretes para continuar a estudar, após a integração completa do sistema de notificações.

## 🔧 Estado de Desenvolvimento

O Student Mate encontra-se em desenvolvimento.

O repositório inclui a implementação inicial de várias funcionalidades, mas ainda existem componentes que necessitam de integração e correção.

### Melhorias Planeadas

- Completar a estrutura do projeto Android Studio.
- Finalizar a integração da base de dados Room.
- Corrigir a navegação entre os diferentes ecrãs.
- Garantir a atualização automática da lista de flashcards.
- Melhorar a gestão de notificações e permissões Android.
- Permitir editar flashcards existentes.
- Implementar técnicas de revisão espaçada.
- Adicionar estatísticas mais detalhadas.
- Melhorar a interface e a experiência de utilização.
- Realizar testes de funcionamento e compatibilidade.

## 📌 Repositório

Código-fonte disponível em:

https://github.com/Simao-PB/Student_mate

---

**Student Mate — Organiza, estuda e acompanha o teu progresso! 📚**
