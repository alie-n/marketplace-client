#!/bin/bash

if [[ $TRAVIS_COMMIT_MESSAGE != "update javadoc" ]]; then

    git config --global user.name "travis-ci"
    git config --global user.email "travis@travis-ci.org"

    cd $HOME

    git clone --quiet --branch=master https://$GITHUB_TOKEN@github.com/xxcw/marketplace-webapp-client.git marketplace-webapp-client

    rm -r $HOME/marketplace-webapp-client/docs/apidocs
    cp -r $HOME/build/xxcw/marketplace-webapp-client/target/site/apidocs $HOME/marketplace-webapp-client/docs/

    cd $HOME/marketplace-webapp-client

    git add -f .
    git commit -m "update javadoc"
    git push -fq https://$GITHUB_TOKEN@github.com/xxcw/marketplace-webapp-client master

    rm -rf $HOME/marketplace-webapp-client

fi