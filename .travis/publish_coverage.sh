#!/bin/bash

if [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

    echo -e "Generating code coverage reports...\n"
    cd ./gode-sunder
    sbt coveralls
    sbt coverageReport

    echo -e "...publishing coverage reports...\n"

    git config --global user.email "travis@travis-ci.org"
    git config --global user.name "travis-ci"
    git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/ScalABM/models-library gh-pages

    cd gh-pages

    # copy over the new coverage stats
    mkdir -p ./coverage/gode-sunder/master
    cp -Rf ../target/scala-2.11/scoverage-report ./coverage/gode-sunder/master

    # push to github!
    git add ./coverage
    git commit -m "Latest coverage report on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
    git push origin gh-pages

    echo -e "Published coverage reports to gh-pages!\n"
fi
