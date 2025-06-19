
🤖 J’ai exploré deux approches pour intégrer un modèle de langage (LLM) comme Ollama dans une application Spring Boot…

🛠️ Approche 1 — RestTemplate (manuelle)
— Contrôleur utilisé : SimpleChatbotController

➡️ Appels directs à l’API REST d’Ollama
✅ Contrôle total sur les requêtes, les headers, et le format JSON
❌ Code verbeux, fragile, peu réutilisable et difficile à maintenir

✨ Approche 2 — Spring AI
— Contrôleur utilisé : SpringAIChatbotController

➡️ Abstraction native pour les LLM dans l’écosystème Spring
✅ Intégration fluide avec portabilité entre plusieurs fournisseurs (OpenAI, Gemini, Ollama…)
✅ Fonctionnalités avancées : Function Calling, RAG, prompt templates, etc.
❌ Moins de contrôle bas niveau, mais largement compensé par la productivité

🎯 Mon verdict
Spring AI l’emporte haut la main :

✔️ Plus propre

✔️ Plus robuste

✔️ Plus évolutif



 
