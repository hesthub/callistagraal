FROM paketobuildpacks/builder-jammy-tiny:0.0.230

COPY build/native/nativeCompile/CallistaGraal /app

CMD ["/app"]
