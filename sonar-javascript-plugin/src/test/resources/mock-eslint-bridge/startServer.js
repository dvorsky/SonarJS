#!/usr/bin/env node

/**
 * Note that any edits in this file have to be repackaged to the mock-eslint-bundle.tar.xz to be effective for tests
 */

const http = require('http');
const port = process.argv[2];

const requestHandler = (request, response) => {
  if (request.url === '/status' || request.url === '/new-tsconfig') {
    response.writeHead(200, { 'Content-Type': 'text/plain' });
    response.end('OK!');
  } else {
    response.end("{ issues: [] }");
  }
};

const server = http.createServer(requestHandler);

server.listen(port, (err) => {
  if (err) {
    return console.log('something bad happened', err)
  }

  console.log(`server is listening on ${port}`)
});
