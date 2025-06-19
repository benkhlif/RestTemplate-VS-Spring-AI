J’ai récemment testé deux approches pour intégrer des modèles de langage (LLM) comme Ollama dans mon application Spring Boot… et les enseignements sont clairs ! ⚖️ 

🛠️ RestTemplate (approche manuelle) : appel direct à l’API REST d’Ollama. On garde le contrôle, mais on gère soi-même les JSON, les en-têtes HTTP, et tous les détails d’intégration. 
Résultat : un code sur-mesure, mais fragile, peu réutilisable, et difficile à faire évoluer. 

✨ Spring AI (approche abstraite) : une intégration pensée pour les développeurs. Fini la complexité HTTP, tout est encapsulé dans des composants Spring. Le vrai plus ? La portabilité : on peut passer d’un LLM à un autre (OpenAI, Gemini…) sans revoir toute l’architecture. 

🎯 Mon verdict ? Spring AI l’emporte haut la main. Plus clair, plus propre, plus robuste.
 Et surtout : il ouvre la voie à des fonctionnalités avancées comme le Function Calling (exécution de fonctions Java pilotées par l’IA) 
