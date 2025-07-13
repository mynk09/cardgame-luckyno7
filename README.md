# ♠ Lucky No. 7 - Android Card Game

**Lucky No. 7** is a turn-based multiplayer card game built with Jetpack Compose and Kotlin. Players try to reduce the value of their hands using clever discards — with the twist that 7 is worth 0!

---

## 🎯 Game Objective

Minimize the total value of your 5-card hand. Use discards wisely, draw strategically, and call **"Check"** when you believe you're holding the lowest score.

---

## 🕹️ Gameplay Rules

1. Each player starts with **5 cards**.
2. **Card values**:
   - **A** = 1  
   - **2–6**, **8–10** = Face value  
   - **7** = 0 ✅ (Lucky!)  
   - **J** = 11, **Q** = 12, **K** = 13
3. On their turn, a player:
   - Discards **one card**, or **all cards with the same value**
   - Draws a card either from the **main deck** or the **previous player’s discarded pile**
4. One round = all 4 players taking a turn.
5. After **3 full rounds**, any player may call **"Check"** to end the game and compare scores.
6. If the **caller has the lowest score**, they win.  
   If **another player has equal or lower score**, the caller is penalized and that player wins instead.

---

## 🛠️ Project Setup

### 🔧 Requirements
- Android Studio Hedgehog or later
- Kotlin 2.0.21
- Jetpack Compose Compiler 1.5.0+
- Android SDK 36 (or update `compileSdk` accordingly)

### ⚙️ Libraries Used
- **Jetpack Compose** for UI
- **ViewModel** for state management (MVVM)
- **Material 3** for modern UI components
- **Version Catalog** (`libs.versions.toml`) to manage dependencies

---

## 📁 Folder Structure

LuckyNo7/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/gzone/luckyno7/
│   │       │       ├── Card.kt
│   │       │       ├── Deck.kt
│   │       │       ├── GameViewModel.kt
│   │       │       ├── CardGameScreen.kt
│   │       │       └── model/
│   │       │           └── Player.kt
│   │       └── res/
│   │           └── drawable/
│   │               ├── 2_clubs.png
│   │               ├── 7_spades.png
│   │               └── ...


---

## 🖼️ Card Image Setup

- All 52 card images should be placed in:  
  `app/src/main/res/drawable/`
- Image filenames follow the format:  
  `2_clubs.png`, `7_spades.png`, `K_hearts.png`, etc.
- The app dynamically loads images using the card's value and suit

---

## 🚀 Running the App

1. **Clone the project**:
   ```bash
   git clone https://github.com/yourusername/LuckyNo7.git

Open the project in Android Studio

Sync Gradle to download dependencies.

Build and Run:

Use the emulator (e.g., Pixel 5, API 30+) or a physical Android device.

The app will display a card table with visible cards for all players (initial development mode).   



## 🧠 Game Logic Status
Feature	Status
Initial 5-card deal	✅ Done
Discard logic	✅ Done
Shared discard pile	✅ Done
Turn management	✅ Done
Round tracking	✅ Done
Score calculation	✅ Done
"Check" call flow	⚙️ In Progress
Determine winner	⚙️ In Progress
Hide opponents' cards	🔜 Planned
Game animations/sounds	🔜 Planned
Multiplayer / AI	🔜 Planned

## 🧩 Planned Features
🔒 Hide other players’ cards (only show your own hand)

🔁 Undo last action

📊 Persistent scoreboard

🎵 Sound effects & animations (deal, discard)

🌐 Multiplayer mode over LAN or Internet

🤖 AI-controlled players for solo play

## 📄 License
This project is licensed under the MIT License.

You are free to:

Use this project for personal or commercial purposes

Modify or distribute it with attribution

Submit pull requests or improvements

## 🙌 Credits
Built by Mayank Savarn (GZone Games)
Developed using Jetpack Compose and Kotlin.
Game concept, UI logic, and rule design handcrafted with care.

Special thanks to:

Android community

Jetpack Compose team

Open-source card asset creators
   
