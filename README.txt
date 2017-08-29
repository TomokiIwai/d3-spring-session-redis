This software is released under the MIT License, see LICENSE file

[必要な前提条件]
* Redisサーバーを起動するために、docker、docker-composeがインストール済みであること

[Redisサーバー起動手順]
* cd docker
* docker-compose build
* docker-compose up -d

[Redisの内容確認]
* Medisを使う（https://github.com/luin/medis）
 * cloneしてnpm install & npm run build & npm run electron
