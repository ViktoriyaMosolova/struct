//-----------------------2------------------------------
//Абстрактный класс или интерфейс     
//Доказать почему     
//Абстрактный класс DataBase:     
// DataBase является абстрактным классом, который определяет базовый функционал для работы с данными из базы данных.     
// Этот класс содержит абстрактную функцию getAll(), которую должны реализовать его подклассы.     
// Использование абстрактного класса позволяет определить общую структуру и функциональность для классов,     
// работающих с различными источниками данных (локальной и удалённой базами данных).     
//Конкретные классы DataBaseLocal и DataBaseRemote:     
// DataBaseLocal и DataBaseRemote являются конкретными реализациями абстрактного класса DataBase.     
// Каждый из них реализует метод getAll() для получения данных из конкретного источника (локальной или удалённой базы данных).     
// Здесь абстрактный класс DataBase определяет общий интерфейс (через абстрактный метод), который должен быть реализован в каждом конкретном классе.     
//Интерфейс NoteRepository:     
// NoteRepository представляет интерфейс для работы с репозиторием заметок.     
// Он определяет одну функцию getAllNotes(), которая должна быть реализована классами, предоставляющими доступ к заметкам     
// (независимо от того, работают они с локальными или удалёнными данными).     
//Классы NoteRepositoryImplLocal и NoteRepositoryImplRemote:     
// NoteRepositoryImplLocal и NoteRepositoryImplRemote реализуют интерфейс NoteRepository.     
// Каждый из этих классов предоставляет реализацию метода getAllNotes() для получения списка заметок из локальной или удалённой базы данных соответственно.     
// Использование интерфейса NoteRepository позволяет абстрагироваться от конкретной реализации и обращаться к репозиторию заметок через общий интерфейс,     
// что упрощает поддержку и расширение системы.     
//
// Таким образом, использование абстрактных классов и интерфейсов в данном примере позволяет разделить ответственность,     
// обеспечивая гибкость и расширяемость кода. Абстрактные классы определяют общую структуру и частичную реализацию функциональности,     
// в то время как интерфейсы определяют контракт, который должны выполнять классы-реализации.     
// Это способствует управлению зависимостями и обеспечивает лёгкость внесения изменений и замены компонентов системы.     