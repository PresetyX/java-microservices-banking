#!/usr/bin/env bash
set -euo pipefail

docker compose up -d postgres kafka
printf 'Dependencies started. Run each Spring Boot service with Maven.\n'
