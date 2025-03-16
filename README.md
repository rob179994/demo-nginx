# demo-nginx

Run:
```bash
docker compose up --build    
```

Test with:
```bash
for i in {1..30}; do curl -s http://localhost:8090/helloWithDelay; echo; done
```