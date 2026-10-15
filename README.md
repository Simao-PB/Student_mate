🎓 Student Mate

Student Mate é uma aplicação móvel para Android, desenvolvida em Java, que pretende ajudar estudantes a organizar sessões de estudo, rever conteúdos com flashcards e acompanhar o progresso da aprendizagem.
O projeto reúne ferramentas de revisão, agendamento de lembretes e visualização de estatísticas numa interface simples e focada no estudo.
Estado do projeto: protótipo em desenvolvimento. O repositório contém código-fonte e recursos da aplicação, mas ainda não constitui um projeto Android Studio completo e compilável de forma autónoma.

✨ Funcionalidades
📚 Flashcards
- Criação de cartões com pergunta, resposta e tema.
- Associação automática ao tema Geral quando nenhum tema é indicado.
- Consulta das respostas dos cartões.
- Registo das revisões realizadas, incluindo data da última revisão e contador de revisões.
- Eliminação de cartões.
- Interface baseada em RecyclerView para apresentar os cartões.
📅 Cronograma de revisões
- Escolha de uma data e hora para agendar um lembrete.
- Opção de agendar uma revisão para as 09:00 do dia seguinte.
- Identificação dos cartões que ainda não foram revistos ou cuja última revisão ocorreu há mais de 24 horas.
- Utilização de alarmes e notificações locais do Android para os lembretes de estudo.
📊 Estatísticas de estudo
- Contagem de cartões por tema.
- Contagem de cartões revistos pelo menos uma vez.
- Cálculo da percentagem de cartões revistos por tema.
- Barra de progresso geral das revisões.
🎯 Personalização e concentração
- Modo de foco, que simplifica o ecrã de flashcards, ocultando alguns elementos da interface.
- Opção de alternância entre os temas claro e escuro.
Algumas destas funcionalidades já têm lógica implementada, mas necessitam de integração e correções para funcionar de ponta a ponta.

🛠️ Tecnologias utilizadas
Tecnologia	Utilização
Java	Lógica da aplicação Android
Android SDK	Componentes e funcionalidades do sistema operativo
XML	Definição dos ecrãs e recursos visuais
AndroidX / AppCompat	Compatibilidade e estrutura das atividades
RecyclerView	Apresentação dos flashcards
Material Components	Componentes da interface
Room	Persistência local prevista e referenciada no código
AlarmManager	Agendamento de lembretes
NotificationCompat	Construção de notificações locais


📂 Estrutura do repositório
Atualmente, os ficheiros encontram-se na raiz do repositório. Entre os principais estão:
Student_mate/
├── MainActivity.java             # Ecrã principal e navegação
├── FlashcardsActivity.java       # Gestão das ações sobre os cartões
├── Flashcard.java                # Modelo de dados dos flashcards
├── FlashcardAdapter.java         # Adapter para a lista de cartões
├── CronogramActivity.java        # Agendamento de revisões
├── StaticsActivity.java          # Estatísticas por tema
├── AlarmUtils.java               # Configuração dos alarmes
├── NotificationHelper.java       # Criação de notificações
├── NotificationReceiver.java     # Receção dos alarmes
├── BootReceiver.java             # Receiver para reinício do dispositivo
├── AndroidManifest.xml           # Configuração Android (parcial)
├── activity_*.xml                # Layouts dos ecrãs
├── dialog_add_card.xml           # Formulário de criação de cartões
├── item_flashcard.xml            # Layout de cada cartão
├── ic_*.xml                      # Recursos gráficos
├── colors.xml / strings.xml      # Recursos da aplicação
├── styles.xml / themes.xml       # Estilos e temas
└── README.md

🚀 Como obter o código
Clona o repositório através do Git:
git clone https://github.com/Simao-PB/Student_mate.git
cd Student_mate
Execução no Android Studio
O repositório ainda não inclui os ficheiros Gradle nem toda a estrutura de um projeto Android Studio. Para executar a aplicação, é necessário concluir essa estrutura antes de compilar:
1. Criar/configurar um projeto Android em Java no Android Studio.
2. Organizar os ficheiros Java nos respetivos pacotes e os recursos XML nas pastas res adequadas.
3. Adicionar as dependências AndroidX, Material Components, RecyclerView e Room.
4. Implementar/integrar as classes AppDatabase e FlashcardDao, referenciadas pelo código mas ausentes do repositório.
5. Corrigir as referências entre atividades, layouts, identificadores e temas no AndroidManifest.xml e nos recursos.
6. Configurar as permissões necessárias às notificações e aos alarmes, conforme a versão do Android.
7. Compilar e testar num emulador ou dispositivo Android.
Nota: o projeto não deve ser considerado pronto a executar apenas com o comando git clone.
🔧 Próximos passos
- [ ] Organizar o repositório como projeto Android Studio completo, com configuração Gradle.
- [ ] Completar a camada de persistência local com Room.
- [ ] Carregar e atualizar corretamente a lista de flashcards após operações de criação, revisão e eliminação.
- [ ] Rever a navegação, os identificadores dos layouts, as atividades declaradas e os temas.
- [ ] Validar notificações e permissões nas versões Android suportadas.
- [ ] Implementar o reagendamento dos lembretes após reiniciar o dispositivo.
- [ ] Testar os principais fluxos da aplicação e adicionar capturas de ecrã.
