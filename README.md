# Secure Notes App 
A **Java Based Secure Note Application** that lets you to **Add, Create, View, Delete** notes all while keeping your notes safe using **AES encryption** which encrypt every note before saving it to local disk and decrypt only when note is viewed,
ensuring privacy and security.


## Features
1. **Add Note**  - Create new note(encrypted before saving).
2. **View Note** - Displays Notes automatically after Decrypting it.
3. **Update Note** - Modifying Existing Notes securely.
4. **Delete Note** - Removes notes by ID.
5. **Storage** - Encrypted notes are stored securely in a file(notes.txt).
6. **AES Encryption** -Content is unreadable in raw storage.


## Tech STack
  -**Language**: Java
  
  **Encryption**: AES(Advanced Encryption Standard)
  
  **Storage**: Local File System
  
  **IDE used**:  IntelliJ

## How to RUN
  1. Clone Repository
        ```bash
        git clone
        https://github.com/nitin99-cyber/SecureNotesApp.git
        cd SecureNotesApp
  2. Compile the Code:
       ```bash
        java SecureNotesApp.java CryptoUtils.java
     
  3. Run the Program:
     ```bash
      java SecureNotesApp


## Project Structure
    SecureNotesApp/
    |--- SecureNotesApp.java      #main program with menu & CRUD
    |--- CryptoUtils.java      #AES encryption/Decryption utilities
    |--- Note.java              # Note modal class
    |--- notes.txt              # File storage(encrypted content)
    |--- README.md              # Project Documentation



## Encryption Example
    notes.txt contains encrypted text,
    example:   1. Password;GHpE2g6r8h==
               2. Friends; TQz3keRnt8==

              When viewed through App:
                1. Password;Nitin@2025
                2. Friends; Aryan,Vishal,Kartik,Aditya

## Future Improvements
      1. Password Login
      2. GUI Version
      3. Search notes by Titile
      4. Export/Import encrypted notes

   **If you want to contribute and help me in making future improvements, feel free to contact me.**


## Author

    Nitin Deep
    Github: @nitin99-cyber
    Linkedin: https://www.linkedin.com/in/nitindeep9

### If you love this repo and find useful, Star it.
